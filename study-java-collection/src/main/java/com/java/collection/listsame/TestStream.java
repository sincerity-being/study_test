package com.java.collection.listsame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-08 16:08
 * @describe
 */
public class TestStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        list.stream().filter(l -> l.equals(1)).findAny().orElse(null);
        list.add(0);
     //   list.add(3,3);
        System.out.println(list);
        System.out.println(80/100);
    }
}
