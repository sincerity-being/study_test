package com.hyq.interview.qianfeng.singleton;

/**
 * @author 徒有琴
 */
public class Singleton2 {

    private static class SingletonHolder {
        private static Singleton2 instance = new Singleton2();
    }

    private Singleton2() {
        System.out.println("Singleton2 loaded");
        if (SingletonHolder.instance != null) {
            throw new IllegalStateException();
        }
    }

    public static Singleton2 getInstance() {
        return SingletonHolder.instance;
    }

}
