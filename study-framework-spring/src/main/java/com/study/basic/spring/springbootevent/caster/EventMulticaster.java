package com.study.basic.spring.springbootevent.caster;

import com.study.basic.spring.springbootevent.evnet.WeatherEvent;
import com.study.basic.spring.springbootevent.listener.WeatherListener;

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
