package com.study.basic.oop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-26 09:29
 * @describe
 */
public class Demo {

   private Integer a = 1;
    public static void main(String[] args) {
        System.out.println(new Demo().a);
        Map<Integer,String> map = new HashMap<>(16);
        map.put(2,"Bob");
        map.put(13,"John");
        map.put(29,"George");
        map.put(1,"Alice");
        for (Integer key : map.keySet()){
            System.out.println(map.get(key));
        }
    }
}
