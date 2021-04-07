package com.java.st.collection.source;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-02-22 08:25
 * @describe
 */
public class HashMapDemo1 {
    public static void main(String[] args) {
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
