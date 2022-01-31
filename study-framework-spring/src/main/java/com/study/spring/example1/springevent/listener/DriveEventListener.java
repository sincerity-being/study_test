package com.study.spring.example1.springevent.listener;

import com.study.spring.example1.springevent.DriveEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/***
 *https://www.jianshu.com/p/786509ddb853
 *事件监听机制
 *@author: HeYQ
 *@date: 2020-07-15 15:02
 *@describe:
 *@version:
 */

//代码:https://www.jianshu.com/p/786509ddb853
@Component
public class DriveEventListener implements ApplicationListener<DriveEvent> {

    @Override
    public void onApplicationEvent(DriveEvent driveEvent) {
        System.out.println("本次哈哈列车开往目的地:" + driveEvent.getDestination());
    }
}
