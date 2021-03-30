package com.study.spring.springbootevent.caster;

import com.study.spring.springbootevent.evnet.WeatherEvent;
import com.study.spring.springbootevent.listener.WeatherListener;

import java.util.ArrayList;
import java.util.List;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-15 17:16
 *@describe:
 *@version:
 */
public class WeatherEventMulticaster implements EventMulticaster {

    private List<WeatherListener> listenerList = new ArrayList<>();
    @Override
    public void multicastEvent(WeatherEvent event) {
        System.out.println("==========开始事件广播==========");
        listenerList.forEach(i -> i.onWeatherEvent(event));
        System.out.println("==========结束事件广播==========");
    }

    @Override
    public void addListener(WeatherListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void removeListener(WeatherListener listener) {
        listenerList.remove(listener);
    }
}
