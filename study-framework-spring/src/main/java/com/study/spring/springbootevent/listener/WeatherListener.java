package com.study.spring.springbootevent.listener;

import com.study.spring.springbootevent.evnet.WeatherEvent;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-15 17:09
 *@describe:
 *@version:
 */
public interface WeatherListener {

    void onWeatherEvent(WeatherEvent event);
}
