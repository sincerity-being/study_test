package com.study.spring.springbootevent.caster;

import com.study.spring.springbootevent.evnet.WeatherEvent;
import com.study.spring.springbootevent.listener.WeatherListener;

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
