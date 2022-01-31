package com.study.spring.example1.springbootevent.test;

import com.study.spring.example1.springbootevent.caster.EventMulticaster;
import com.study.spring.example1.springbootevent.caster.WeatherEventMulticaster;
import com.study.spring.example1.springbootevent.listener.RainListener;
import com.study.spring.example1.springbootevent.listener.SnowListener;
import com.study.spring.example1.springbootevent.evnet.RainWeatherEvent;
import com.study.spring.example1.springbootevent.evnet.SnowWeatherEvent;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-15 17:18
 *@describe:
 *@version:
 */
public class Start {

    public static void main(String[] args) {
        // 创建广播对象
        EventMulticaster eventMulticaster = new WeatherEventMulticaster();
        // 创建下雨事件监听对象
        RainListener rainListener = new RainListener();
        // 创建下雪事件监听对象
        SnowListener snowListener = new SnowListener();

        // 添加下雨、下雪监听事件对象
        eventMulticaster.addListener(rainListener);
        eventMulticaster.addListener(snowListener);

        // 广播下雨事件
        eventMulticaster.multicastEvent(new RainWeatherEvent());
        // 广播下雪事件
        eventMulticaster.multicastEvent(new SnowWeatherEvent());

        // 移除下雨监听事件对象
        eventMulticaster.removeListener(rainListener);

        // 广播下雨事件
        // 广播下雪事件
        eventMulticaster.multicastEvent(new RainWeatherEvent());
        eventMulticaster.multicastEvent(new SnowWeatherEvent());
    }
}
