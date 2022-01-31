package com.study.designpattern.boke.eventlistener.impl;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import com.study.designpattern.boke.eventlistener.event.ICurdEvent;
import com.study.designpattern.boke.eventlistener.event.IListenerable;

/**
 *事件实现类
 * <p>  </p>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @since 1.0
 */
public class CurdEvent implements ICurdEvent {
    //事件源
    private IListenerable eventSource;
    //事件源所执行的方法名称
    private String methodname;
    public CurdEvent(IListenerable eventSource,String methodname){
        super();
        this.eventSource = eventSource;
        this.methodname = methodname;
    }
    @Override
    public IListenerable getEventSource() {
        return eventSource;
    }
    //根据事件源所执行的不同的方法返回不同的事件类型
    @Override
    public String getEventType() {
        String eventType = null;
        if (methodname.startsWith("save")){
            eventType = Create_EVENT;
        }else if (methodname.startsWith("remove")){
            eventType = Delete_EVENT;
            //修改
        }else if (methodname.startsWith("modify")){
            eventType = Update_EVENT;
        }else if (methodname.startsWith("find")){
            eventType = Retrieve_EVENT;
        }else {
            eventType = "have not this event type";
        }
        return eventType;
    }
}
