package com.study.spring.example1.springbootevent.listener;

import com.study.spring.example1.springbootevent.evnet.WeatherEvent;

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
