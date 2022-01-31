package com.study.basic.reflect;

import java.util.concurrent.TimeUnit;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-15 11:51
 * @describe
 */
public class MainDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("==========1");
        TimeUnit.SECONDS.sleep(1000);
    }
}

class MainDemo1{
    public static void main(String[] args) throws Exception {
        System.out.println("==========2");
        TimeUnit.SECONDS.sleep(1000);
    }
}
