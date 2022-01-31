package com.study.spring.example1.springbootevent.evnet;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-15 17:05
 *@describe:
 *@version:
 */
public class RainWeatherEvent implements  WeatherEvent {
    @Override
    public String getWeather() {
        return "下雨";
    }
}
