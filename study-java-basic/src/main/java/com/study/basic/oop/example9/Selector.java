package com.study.basic.oop.example9;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 20:32
 * @describe 迭代器设计模式
 */
public interface Selector {
    boolean end();

    Object current();

    void next();
}
