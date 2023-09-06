package com.study.basic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-19 19:56
 * @describe
 */
public class ListDemo {

    public static void main(String[] args) {

        List<Integer> aList = Arrays.asList(1,2,3,4);
    //    List<Integer> list = aList.stream().filter(r -> r > 2).collect(Collectors.toList());

        int sum = aList.stream().filter(r -> r > 2).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

    }
}
