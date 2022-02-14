package com.study.basic.oop.example5.deal;

import com.study.basic.oop.example5.bean.Waveform;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 11:57
 * @describe
 */
public class BandPass extends Filter{

    double lowCutoff, highCutoff;

    public BandPass(double lowCutoff, double highCutoff){
        this.lowCutoff = lowCutoff;
        this.highCutoff = highCutoff;
    }

    @Override
    public Waveform process(Waveform input){
        return input;
    }
}
