package com.study.basic.collection.source;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-11 11:31
 * @describe
 */
public class HashMapDemo {

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30. 2^30 次方.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        System.out.println("==========================");
        // 指定初始容量为15 ,真实容量不会是15 离2的次方 最近的 数 16 并且扩容也是 16
        Map<String,String> stringMap = new HashMap<>(15);
        stringMap.put("hyq","1");
        System.out.println(2 << 1);
        //Dictionary

        System.out.println(tableSizeFor(130));

    }


    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
