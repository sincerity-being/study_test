package com.study.basic.oop.example5.deal;

import com.study.basic.oop.example5.bean.Waveform;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 11:57
 * @describe
 */
public class LowPass extends Filter{
    double cutoff;
    public LowPass(double cutoff){
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input){
        return input;
    }
}
