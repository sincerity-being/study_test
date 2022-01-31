package com.study.basic.springboot.thread.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-23 10:42
 *@describe:
 *@version:
 */
@Component
public class AsyncTask {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //myTaskAsynPool即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
    @Async("myTaskAsyncPool")
    public void doTask1(int i) throws InterruptedException{
        logger.info("Task"+i+" started.");
    }


}
