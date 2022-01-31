package com.study.basic.boke.eventlistener.event;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


/**
 *
 * https://blog.csdn.net/gsjwxhn/article/details/90601466
 *定义增删改查事件
 * //C: Create
 * //U: Update
 * //R: Retrieve
 * //D: Delete
 * //通常对于事件对象，我们一般需要从事件对象中获取到事件源对象
 * <p>  </p>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @since 1.0
 */
public interface ICurdEvent {
    //声明事件类型
    String Create_EVENT = "create event";
    String Update_EVENT = "update event";
    String Retrieve_EVENT = "retrieve event";
    String Delete_EVENT = "delete event";
    //获取事件源对象
    IListenerable getEventSource();
    //获取事件类型
    String getEventType();

}
