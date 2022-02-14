package com.study.basic.oop.example5.bean;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 11:53
 * @describe
 */
public class Waveform {
    private static long counter;

    private final long id = counter++;

    public String toString(){
        return "Waveform "  + id;
    }
}
