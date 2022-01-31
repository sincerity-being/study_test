package com.study.designpattern.boke.eventlistener.event;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


/**
 * 注释..
 * <p>  </p>
 * @author hyq  heyuqiang@kungeek.com
 * @since 1.0
 */
//监听器接口（观察者）
//作用：处理消息（事件）
public interface IListener {
    void handle(ICurdEvent event);
}
