package com.study.basic.annotation.example2;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注释..
 * <p>  </p>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @since 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Values {
    Value[] value();
}

