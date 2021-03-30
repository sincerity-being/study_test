package com.study.spring.springbootevent.listener;

import com.study.spring.springbootevent.evnet.SnowWeatherEvent;
import com.study.spring.springbootevent.evnet.WeatherEvent;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-15 17:13
 *@describe:
 *@version:
 */
public class SnowListener  implements  WeatherListener{
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof SnowWeatherEvent) {
            System.out.println(event.getWeather());
        }
    }
}
