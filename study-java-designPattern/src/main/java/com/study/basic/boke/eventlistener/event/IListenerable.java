package com.study.basic.boke.eventlistener.event;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


/**
 * 注释..
 * <p>  </p>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @since 1.0
 */
//事件源接口（被观察者）
public interface IListenerable {
    //为事件源注册监听器
    void setListener(IListener listener);
    //触发监听器
    void triggerListener(ICurdEvent event);
}
