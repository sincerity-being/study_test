package com.study.spring.example1.springbootevent.caster;

import com.study.spring.example1.springbootevent.evnet.WeatherEvent;
import com.study.spring.example1.springbootevent.listener.WeatherListener;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-15 17:15
 *@describe:
 *@version:
 */
public interface EventMulticaster {

    void multicastEvent(WeatherEvent event);
    void addListener(WeatherListener listener);
    void removeListener(WeatherListener listener);
}
