package com.hyq.interview.qianfeng.singleton;

/**
 * @author 徒有琴
 */
public class Singleton4 {
    private static Singleton4 instance = null;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
