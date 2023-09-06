package com.hyq.interview.qianfeng.singleton.test;


import com.hyq.interview.qianfeng.singleton.Singleton8;
import org.junit.Test;

import java.io.IOException;

/**
 * @author 徒有琴
 */
public class Singleton8Test {
    @Test
    public void test1() {
        Singleton8 s1 = Singleton8.getInstance();
        Singleton8 s2 = Singleton8.getInstance();
        System.out.println(s1 == s2);
    }

    @Test
    public void test2() {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton8 s1 = Singleton8.getInstance();
                    Singleton8 s2 = Singleton8.getInstance();
                    System.out.println(Thread.currentThread().getName() + "," + (s1 == s2) + "  " + s1);
                }
            }).start();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
