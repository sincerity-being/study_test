package com.study.basic.oop.example5;

import com.study.basic.oop.example5.bean.Waveform;
import com.study.basic.oop.example5.deal.Filter;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 12:01
 * @describe
 */
public class FilterAdapter  implements Processor{

    private Filter filter;

    public FilterAdapter(Filter filter){
        this.filter = filter;
    }

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}
