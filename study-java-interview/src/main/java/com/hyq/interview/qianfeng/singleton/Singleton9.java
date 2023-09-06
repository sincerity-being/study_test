package com.hyq.interview.qianfeng.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 徒有琴
 */
public class Singleton9 {
    private static final AtomicReference<Singleton9> instance = new AtomicReference<>();

    private Singleton9() {
        System.out.println("Singleton9 Loaded");
    }

    public static final Singleton9 getInstance() {
        for (; ; ) {
            Singleton9 current = instance.get();
            if (current != null) {
                return current;
            }
            current = new Singleton9();
            if (instance.compareAndSet(null, current)) {
                return current;
            }
        }
    }
}
