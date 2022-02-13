package com.study.basic.oop.example2;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-12 22:26
 * @describe thinking in java的向上转型例子
 */
public class Instrument {
    public void play(){
        System.out.println("Instrument........");
    }

    static  void tune(Instrument i){
        i.play();
    }



}
