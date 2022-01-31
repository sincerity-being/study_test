package com.study.designpattern.boke.eventlistener.test;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import com.study.designpattern.boke.eventlistener.event.IListener;
import com.study.designpattern.boke.eventlistener.impl.Listener;
import com.study.designpattern.boke.eventlistener.impl.Some;

/**
 * 注释..
 * <p>  </p>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @since 1.0
 */
public class Test {

    public static void main(String[] args) {
        //定义监听器
        IListener listener = new Listener();
        //定义事件源
        Some some = new Some();
        //事件源注册监听器
        some.setListener(listener);
        some.saveStudent();
        some.removeStudent();
    }

}
