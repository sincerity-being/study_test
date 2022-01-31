package com.study.basic.annotation.example2;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import java.lang.annotation.*;

/**
 * 注释..
 * <p>  </p>
 * https://blog.csdn.net/weixin_42245133/article/details/99678509
 * @author hyq  heyuqiang@kungeek.com
 * @since 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Values.class)
public @interface Value {
    String value() default "value";
}
