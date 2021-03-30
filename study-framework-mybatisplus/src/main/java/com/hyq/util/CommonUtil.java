package com.hyq.util;


import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://vimsky.com/examples/detail/java-method-org.apache.http.client.fluent.Request.bodyString.html
 *
 *
 *
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-11 14:24
 * @describe
 */
@Slf4j
public class CommonUtil {

    public static String getBodyString(HttpServletRequest request) {
       try{
           BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
           String body = IOUtils.read(reader);
           System.out.println("返回json数据");
           System.out.println(body);
           System.out.println("结束");
          return  body;
       }catch(Exception e){
          log.error("错误信息 :{}",e);

       }
        return  "ok";
    }
}
