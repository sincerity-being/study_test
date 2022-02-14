package com.study.basic.oop.example5;

import com.study.basic.oop.example5.bean.Waveform;
import com.study.basic.oop.example5.deal.BandPass;
import com.study.basic.oop.example5.deal.HighPass;
import com.study.basic.oop.example5.deal.LowPass;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 12:07
 * @describe
 */
public class FilterProcessor {

    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)),w);
        Apply.process(new FilterAdapter(new HighPass(2.0)),w);
        Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)),w);
    }
}
