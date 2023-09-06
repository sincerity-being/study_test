package com.hyq.interview.qianfeng.singleton.test;


import com.hyq.interview.qianfeng.singleton.Singleton9;
import org.junit.Test;


/**
 * @author 徒有琴
 */
public class Singleton9Test {

    @Test
    public void test1() throws Exception {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton9.getInstance());
                }
            }).start();
        }
        System.in.read();
    }
}
