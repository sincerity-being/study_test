package com.study.easyCoding.ebook.chapter07.treadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-13 16:20
 * @describe
 */
public class InitValueInThreadLocal {
    private static final StringBuilder INIT_VALUE = new StringBuilder("init");

    private static final ThreadLocal<StringBuilder> builder = new ThreadLocal<>(){
         @Override
        protected StringBuilder initialValue(){
             return  INIT_VALUE;
         }
    };

    private static class AppendStringThread extends Thread{
        @Override
        public void run(){
            StringBuilder inThread = builder.get();
            for (int i = 0; i < 10 ; i++) {
                inThread.append("-" + i);
            }
            System.out.println(getName() + inThread.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            new AppendStringThread().start();
           // TimeUnit.SECONDS.sleep(100000);
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
