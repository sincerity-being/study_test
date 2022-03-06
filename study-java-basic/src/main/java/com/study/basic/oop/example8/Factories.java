package com.study.basic.oop.example8;

import com.study.basic.oop.example8.factory.Implementation1Factory;
import com.study.basic.oop.example8.factory.Implementation2Factory;
import com.study.basic.oop.example8.factory.ServiceFactory;
import com.study.basic.oop.example8.sample.Service;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 20:05
 * @describe 工厂模式 实现 thinking in java 9章
 */
public class Factories {

    public static void serviceConsumer(ServiceFactory fact){
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        serviceConsumer(new Implementation2Factory());
    }
}
