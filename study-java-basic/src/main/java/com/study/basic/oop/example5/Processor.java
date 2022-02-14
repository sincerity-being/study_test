package com.study.basic.oop.example5;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 11:48
 * @describe thinking in java 第9章
 */
public interface Processor {
    String name();

    Object process(Object input);
}
