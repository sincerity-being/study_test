package com.hyq.interview.qianfeng.singleton.test;


import com.hyq.interview.qianfeng.singleton.Singleton2;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author 徒有琴
 */
public class Singleton2Test {

    @Test
    public void test1() {
//        Singleton2 s1=Singleton2.getInstance();
//        Singleton2 s2=Singleton2.getInstance();
//        System.out.println(s1==s2);
        try {
            Class.forName("episode1.Singleton2");
            Singleton2.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Singleton2.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
       // Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = (Singleton2) constructor.newInstance();
//        System.out.println(s1 == s2);
    }
}
