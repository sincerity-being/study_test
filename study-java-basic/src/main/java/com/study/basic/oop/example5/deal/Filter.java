package com.study.basic.oop.example5.deal;

import com.study.basic.oop.example5.bean.Waveform;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 11:50
 * @describe
 */
public class Filter {
    public String name(){
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input){
        return input;
    }
}
