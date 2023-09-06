package com.hyq.interview.qianfeng.singleton;

/**
 * @author 徒有琴
 */
public class Singleton7 {
    private static volatile Singleton7 instance = null;

    private Singleton7() {
    }

    public static Singleton7 getInstance() {
        if (instance == null) {
            synchronized (Singleton7.class) {
                if (instance == null) {
                    instance = new Singleton7();
                }
            }
        }
        return instance;
    }
}
