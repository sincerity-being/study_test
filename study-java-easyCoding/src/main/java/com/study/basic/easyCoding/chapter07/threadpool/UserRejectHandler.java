package com.study.basic.easyCoding.chapter07.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-13 12:13
 * @describe
 */
public class UserRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("rtask rejected." + executor.toString());
    }
}
