package com.hyq.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hyq.model.BaseModel;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-11 14:26
 * @describe
 */
public class AccountMapper {

    public <T extends BaseModel> UpdateWrapper getUpdateWrapper(T entity){
        UpdateWrapper<T> updateWrapper = new UpdateWrapper<T>();
        try{
            Class clazz = entity.getClass();
            List<Field> fs = Arrays.asList(clazz.getDeclaredFields());
            List<String> updateFieldList = entity.getUpdateFieldList();
            if(updateFieldList!=null){
                for (String updateFiled:updateFieldList ) {
                    for (Field field:fs) {
                        field.setAccessible(true);
                        if(field.getName().toLowerCase().equals(updateFiled)){
                            Object fieldValue = field.get(entity);
                            updateWrapper.set(fieldValue==null,field.getName(),null);
                            continue;
                        }
                    }
                }
            }
            return updateWrapper;
        }catch (Exception e){
            e.printStackTrace();
        }
        return updateWrapper;
    }


}
