package com.study.basic.oop.example8.factory;


import com.study.basic.oop.example8.sample.Implementation2;
import com.study.basic.oop.example8.sample.Service;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 20:04
 * @describe
 */
public class Implementation2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation2();
    }
}
