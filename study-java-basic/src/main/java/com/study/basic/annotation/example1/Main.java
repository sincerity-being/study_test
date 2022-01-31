package com.study.basic.annotation.example1;

import java.lang.reflect.Field;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-11 20:02
 * @describe
 */
public class Main {
    public static void main(String ...args) throws Exception {
        //获取Bar实例
        Bar bar = new Bar();
        //获取Bar的val字段
        Field field = Bar.class.getDeclaredField("val");
        //获取val字段上的Foo注解实例
        Foo foo = field.getAnnotation(Foo.class);
        //获取Foo注解实例的 value 属性值
        String value = foo.value();
        //打印该值
        System.out.println(value);

        int[] a1;

    }
}
