package com.hyq.interview.qianfeng.singleton;

/**
 * @author 徒有琴
 */
public class Singleton5 {
    private static Singleton5 instance = null;

    private Singleton5() {
    }

    public static synchronized Singleton5 getInstance() {
        if (instance == null) {
            instance = new Singleton5();
        }
        return instance;
    }
}
