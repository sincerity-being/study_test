package com.hyq.interview.qianfeng.singleton;

/**
 * @author 徒有琴
 */
public class Singleton6 {
    private static Singleton6 instance = null;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        synchronized (Singleton6.class) {
            if (instance == null) {
                instance = new Singleton6();
            }
        }
        return instance;
    }
}
