package com.study.basic.easyCoding.chapter07.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-13 12:15
 * @describe
 */
public class UserThreadPool {
    public static void main(String[] args) {

        BlockingQueue queue = new LinkedBlockingDeque(2);

        UserThreadFactory f1 = new UserThreadFactory("第1机房");
        UserThreadFactory f2 = new UserThreadFactory("第2机房");

        UserRejectHandler handler = new UserRejectHandler();

        ThreadPoolExecutor threadPoolExecutorFirst = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f1, handler);

        ThreadPoolExecutor threadPoolExecutorSecond = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f2, handler);

        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPoolExecutorFirst.execute(task);
            threadPoolExecutorSecond.execute(task);
        }

    }
}
