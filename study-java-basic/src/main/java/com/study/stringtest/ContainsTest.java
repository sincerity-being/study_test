package com.study.stringtest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-26 14:34
 * @describe
 */
public class ContainsTest {
    public static void main(String[] args) {
         String str = "[123,123]";
        System.out.println(str.contains("1"));
        System.out.println(Integer.valueOf("1000002"));

        List<String> sortList = Arrays.asList("1-2001","3-2001","0-2100","2-2001","0-2011");
        System.out.println(sortList.stream().sorted().collect(Collectors.toList()));
    }

}
