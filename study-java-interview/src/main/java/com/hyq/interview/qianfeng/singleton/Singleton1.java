package com.hyq.interview.qianfeng.singleton;

import java.io.Serializable;

/**
 * 饿汉式
 *
 * @author 徒有琴
 */
public class Singleton1 implements Serializable {
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }
}
