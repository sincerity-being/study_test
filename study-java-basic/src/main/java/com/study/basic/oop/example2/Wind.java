package com.study.basic.oop.example2;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-12 22:28
 * @describe
 */
public class Wind  extends Instrument{

//    @Override
//    public void play(){
//        System.out.println("Wind........");
//    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute);

        Instrument instrument = new Wind();
    }

    public void  stop(){

    }
}
