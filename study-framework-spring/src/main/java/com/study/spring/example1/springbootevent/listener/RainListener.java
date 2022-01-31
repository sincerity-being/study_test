package com.study.spring.example1.springbootevent.listener;

import com.study.spring.example1.springbootevent.evnet.RainWeatherEvent;
import com.study.spring.example1.springbootevent.evnet.WeatherEvent;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-15 17:10
 *@describe:
 *@version:
 */
public class RainListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof RainWeatherEvent) {
            System.out.println(event.getWeather());
        }
    }
}
