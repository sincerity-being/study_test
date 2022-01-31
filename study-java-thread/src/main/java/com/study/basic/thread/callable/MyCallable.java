package com.study.basic.thread.callable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-23 08:20
 *@describe:
 *@version:
 */
//@Slf4j
public class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {

     //log.info("=====gointo Call()" + Thread.currentThread().getName());
      int retValue =10;
/*
      for (int i = 0 ; i <10000; i++){
          Thread.sleep(1000);
      }*/
        return retValue;
    }
}
