package com.hyq.interview.qianfeng.singleton.test;

import com.hyq.interview.qianfeng.singleton.SerializeUtil;
import com.hyq.interview.qianfeng.singleton.Singleton1;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * @author 徒有琴
 */
public class Singleton1Test {

    @Test
    public void test1() {
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = Singleton1.getInstance();
        System.out.println(s1 == s2);
    }

    @Test
    public void test2() {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton1.getInstance());
                }
            }).start();
        }
    }

    @Test
    public void test3() throws Exception {
        Class clazz = Singleton1.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = (Singleton1) constructor.newInstance();
        System.out.println(s1 == s2);
    }

    @Test
    public void test4() {
//        Singleton1 s1 = Singleton1.getInstance();
//        SerializeUtil.serialize(s1);
        Singleton1 s1 = (Singleton1) SerializeUtil.unzerialize();
        Singleton1 s2 = (Singleton1) SerializeUtil.unzerialize();
        System.out.println(s1 == s2);
    }
}
