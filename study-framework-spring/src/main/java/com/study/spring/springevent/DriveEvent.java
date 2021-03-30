package com.study.spring.springevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

/***
 *
 *事件
 *@author: HeYQ
 *@date: 2020-07-15 14:55
 *@describe:
 *@version:
 */
public class DriveEvent extends ApplicationEvent {

    private String  destination;


    public DriveEvent(Object source, String destination){
        super(source);
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
