package com.hyq.interview.qianfeng.singleton.test;


import com.hyq.interview.qianfeng.singleton.SerializeUtil;
import com.hyq.interview.qianfeng.singleton.Singleton3;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author 徒有琴
 */
public class Singleton3Test {
    @Test
    public void test1() {
        Singleton3 s1 = Singleton3.INSTANCE;
        Singleton3 s2 = Singleton3.INSTANCE;
        System.out.println(s1 == s2);
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Singleton3.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton3 s1 = (Singleton3) constructor.newInstance();
    }

    @Test
    public void test3() {
        Singleton3 s1 = Singleton3.INSTANCE;
        SerializeUtil.serialize(s1);
        Singleton3 s2 = (Singleton3) SerializeUtil.unzerialize();
        Singleton3 s3 = (Singleton3) SerializeUtil.unzerialize();
        System.out.println(s2 == s3);
    }
}
