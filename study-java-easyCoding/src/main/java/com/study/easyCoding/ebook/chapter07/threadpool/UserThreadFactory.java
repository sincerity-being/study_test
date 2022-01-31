package com.study.easyCoding.ebook.chapter07.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-13 11:53
 * @describe 线程工厂
 */
public class UserThreadFactory implements ThreadFactory {
    private final String namePrefix;

    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserThreadFactory(String whatFeatureOfGroup) {
        this.namePrefix = "UserThreadFactory's" +  whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        // 这是jdk11 的写法
        Thread thread = new Thread(null,task,name,0,false);
        System.out.println(thread.getName());
        return thread;
    }
}

class Task implements Runnable{

    private final AtomicLong count = new AtomicLong(0L);
    @Override
    public void run() {
        System.out.println("running_" + count.getAndIncrement());
    }
}
