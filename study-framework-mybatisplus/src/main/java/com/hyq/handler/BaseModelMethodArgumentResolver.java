package com.hyq.handler;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hyq.annotation.UpdateRequestBody;
import com.hyq.model.BaseModel;
import com.hyq.util.CommonUtil;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-11 14:20
 * @describe
 */
public class BaseModelMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if (methodParameter.hasParameterAnnotation(UpdateRequestBody.class)) {
            //集合
            if(List.class.isAssignableFrom(methodParameter.getParameterType())){
                ParameterizedType parameterizedType = (ParameterizedType) methodParameter
                        .getGenericParameterType();
                Class clazz = (Class)parameterizedType.getActualTypeArguments()[0];
                //取出List中的真实对象类型
                if(BaseModel.class.isAssignableFrom(clazz)){
                    return true;
                }else{
                    return  false;
                }
            }else{
                //单个对象
                if(BaseModel.class.isAssignableFrom(methodParameter.getParameterType())){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String body = "";
        try {
            HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
            body = CommonUtil.getBodyString(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(List.class.isAssignableFrom(methodParameter.getParameterType())){
            List resultList = new ArrayList();
            ParameterizedType parameterizedType = (ParameterizedType) methodParameter.getGenericParameterType();
            Class clazz = (Class)parameterizedType.getActualTypeArguments()[0];
            List<Field> fs = Arrays.asList(clazz.getDeclaredFields());
            JSONArray array = JSONArray.parseArray(body);
            for (Object temp:array) {
                JSONObject obj = JSONObject.parseObject(temp.toString());
                List<String> updateFieldList = new ArrayList<>();
                for (String key : obj.keySet()) {
                    for (Field filed : fs) {
                        if (key.toLowerCase().equals(filed.getName().toLowerCase())) {
                            updateFieldList.add(key.toLowerCase());
                            continue;
                        }
                    }
                }
                obj.put("updateFieldList",updateFieldList);
                resultList.add(obj);
            }
            return  JSONArray.parseArray(resultList.toString(),clazz);
        }else{
            Class clazz = methodParameter.getParameterType();
            List<String> updateFieldList = new ArrayList<>();
            List<Field> fs = Arrays.asList(clazz.getDeclaredFields());
            JSONObject obj = JSON.parseObject(body);
            for (String key : obj.keySet()) {
                for (Field filed : fs) {
                    if (key.toLowerCase().equals(filed.getName().toLowerCase())) {
                        updateFieldList.add(key.toLowerCase());
                        continue;
                    }
                }
            }
            obj.put("updateFieldList",updateFieldList);
            return JSON.parseObject(obj.toString(),clazz);
        }
    }
}
