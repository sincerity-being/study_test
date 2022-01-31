package com.study.basic.easyCoding.chapter07.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-13 12:39
 * @describe
 */
public class ThreadDemo {

    public static void main(String[] args) {
        //创建一个线程t1
        Thread t1 = new Thread(() -> {
            try {
                //睡眠10秒，防止run方法执行过快，线程组被销毁
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //第一次启动
        t1.start();
    }

}
