package com.study.basic.spring.springbootevent.evnet;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-15 17:06
 *@describe:
 *@version:
 */
public class SnowWeatherEvent implements WeatherEvent {
    @Override
    public String getWeather() {
        return "下雪";
    }
}
