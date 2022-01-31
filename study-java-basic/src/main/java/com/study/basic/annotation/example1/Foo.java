package com.study.basic.annotation.example1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-11 20:01
 * @describe
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Foo {
    String value();
}
