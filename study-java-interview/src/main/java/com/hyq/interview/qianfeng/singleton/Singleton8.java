package com.hyq.interview.qianfeng.singleton;

/**
 * @author 徒有琴
 */
public class Singleton8 {
    private static Singleton8 instance = null;

    private Singleton8() {
    }

    private static final ThreadLocal<Singleton8> threadLocalSingleton = new ThreadLocal<Singleton8>() {
        @Override
        protected Singleton8 initialValue() {
            return new Singleton8();
        }
    };

    public static Singleton8 getInstance() {
        return threadLocalSingleton.get();
    }
}
