package com.study.basic.annotation.example2;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 注释..
 * <p>  </p>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @since 1.0
 */
public class AnnotationTest {
    @Value("hello")
    @Value("world")
    public void test(String var1, String var2) {
        System.out.println(var1 + " " + var2);
    }

    // 获取使用`@Value`注解的`test`方法，并打印这个方法上的注解长度和信息
    @Test
    public void testValue() {
        Method[] methods = AnnotationTest.class.getMethods();
        for (Method method : methods){
            if (method.getName().equals("test")) {
                Annotation[] annotations = method.getDeclaredAnnotations();
                System.out.println(annotations.length);
                System.out.println(method.getName() + " = " + Arrays.toString(annotations));
            }
        }
    }

}
