package com.study.basic.packtest.example1.dessert;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-03 11:59
 * @describe
 */
public class Cookie {
    public Cookie(){
        System.out.println("Cookie constructor");
    }

    // 包访问权限
    void bite() {
        System.out.println("bite");
    }

    // 保护访问权限
    protected void bite1(){
        System.out.println("bite1");
    }

}
