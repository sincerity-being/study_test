package com.study.basic.oop.example8.sample;

import static com.study.basic.util.Print.print;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 20:03
 * @describe
 */
public class Implementation2 implements Service{
    @Override
    public void method1() {
        print("Implementation2 method1");
    }

    @Override
    public void method2() {
        print("Implementation2 method2");
    }
}