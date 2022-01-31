package com.study.basic.spring.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.stereotype.Component;

/***
 *
 *事件广播机制(事件发布)
 *@author: HeYQ
 *@date: 2020-07-15 15:06
 *@describe:
 *@version:
 */
@Component
public class Driver {

    //再次应证 使用注解注入组件,不要自己去new 对象,要使用容器中已经有的组件.
  /*  private ApplicationContext applicationContext = SpringContextHolder
                                                       .getApplicationContext();*/
    @Autowired
    private ApplicationContext applicationContext;
    public void drive(String destionation){
        System.out.println("司机开车前往目的地");

        //Exception in thread "main" java.lang.IllegalArgumentException: null source
        //现在没事了.
        DriveEvent driveEvent = new DriveEvent(applicationContext,destionation);

        //DriveEvent driveEvent = new DriveEvent("事件触发了",destionation);

        //发布事件
        applicationContext.publishEvent(driveEvent);
    }


}
