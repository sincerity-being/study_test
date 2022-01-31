package com.study.basic.easyCoding.chapter07.treadlocal;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-13 19:28
 * @describe
 */
public class StringBuilderDemo {

    private static  final StringBuilder INIT_VALUE = new StringBuilder("init");

    private static  StringBuilder staticbian = new StringBuilder("staticbian");

    private StringBuilder bian = new StringBuilder("bian");

    public static void main(String[] args) {
        INIT_VALUE.append("111234444444444444444444444444444444444444444444444444444444");
        System.out.println(INIT_VALUE);
        staticbian.append("222");
        System.out.println(staticbian);

        System.out.println(new StringBuilderDemo().bian.append("3333333"));
    }


}
