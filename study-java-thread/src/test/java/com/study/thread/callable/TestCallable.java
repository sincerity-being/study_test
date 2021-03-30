package com.study.thread.callable;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-23 08:25
 *@describe:
 *@version:
 */
@Slf4j
public class TestCallable {

    @Test
    public  void test() throws  Exception{

        while(true){
            log.info("===================first===");
            FutureTask<Integer> task = new FutureTask<Integer>(new MyCallable());
           log.info("================创建了任务...");
            Thread thread = new Thread(task);
            thread.start();
             log.info("========== 开始接受callable返回结果吗");

           // log.info(Thread.currentThread().getName() + " " + task.get() );
            //若没有对返回结果进行处理,主线程就不会在等待子线程的处理...
        }


    }

    @Test
    public  void test1() throws  Exception{


            log.info("===================first===");
            FutureTask<Integer> task = new FutureTask<Integer>(new MyCallable());
            log.info("================创建了任务...");
            Thread thread = new Thread(task);
            thread.start();
            log.info("========== 开始接受callable返回结果吗");


            log.info(Thread.currentThread().getName() + " " + task.get() );
            //若没有对返回结果进行处理,主线程就不会在等待子线程的处理...

    }


    @Test
    public  void test2() throws  Exception{


        log.info("===================first===");
        FutureTask<Integer> task = new FutureTask<Integer>(new MyCallable());
        log.info("================创建了任务...");
        Thread thread = new Thread(task);
        thread.start();
        log.info("========== 开始接受callable返回结果吗");
        CallableResult callableResult = new CallableResult();
        callableResult.setSubmit(task);

        // log.info(Thread.currentThread().getName() + " " + task.get() );
        //若没有对返回结果进行处理,主线程就不会在等待子线程的处理...
       // log.info(Thread.currentThread().getName() + " " + callableResult.getSubmit().get());
        log.info(Thread.currentThread().getName() + " " + callableResult.getSubmit());
    }


    /***
     * 使用这种方式执行callable不能够进入当前MyCallable代码中...
     * @throws Exception
     */
    @Test
    public void testExeCutorService() throws Exception{

        log.info("===================first===");
        ExecutorService executorService = new MyExeCutorServiceImpl();

        Future<Integer> submit = executorService.submit(new MyCallable());
        log.info("================创建了任务...");
        log.info("========== 开始接受callable返回结果吗");
        CallableFutureResult callableFutureResult = new CallableFutureResult();
        callableFutureResult.setSubmit(submit);
        log.info(Thread.currentThread().getName() + " " + callableFutureResult.getSubmit());
        log.info(Thread.currentThread().getName() + " " + callableFutureResult.getSubmit().get());

    }
}
