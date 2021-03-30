package com.study.date.year;

import cn.hutool.core.date.DateUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-10 14:09
 * @describe
 */
public class TestGainYearDemo {

    public static void main(String[] args) {
        Date date = DateUtil.date();
      int i =  DateUtil.year(date);
        System.out.println(i);
        String str = "2020";
        System.out.println(str.substring(0,3));
        System.out.println(str.substring(0,4));
       // System.out.println(str.substring(0,5));
        List<Integer> test = Arrays.asList(01,02,10);
        System.out.println(test.stream().max(Integer::compareTo));
        System.out.println(Integer.valueOf("01"));
        String string = "12-01-2020";
        System.out.println(string.substring(string.indexOf("-")+1,string.indexOf("-",string.indexOf("-")+1)));


        String string1 = "01-2020";
        System.out.println(string1.substring(0,string.indexOf("-",string.indexOf("-"))));
        System.out.println();
    }


}
