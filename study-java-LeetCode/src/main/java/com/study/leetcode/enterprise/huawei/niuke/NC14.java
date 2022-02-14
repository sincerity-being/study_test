package com.study.leetcode.enterprise.huawei.niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-13 16:37
 * @describe 按之字形顺序打印二叉树
 */
public class NC14 {

    public static void main(String[] args) {
      //  testHashMap();










    }









    private static void testHashMap() {
        Map<Integer, String> map = new HashMap<>(16);
        map.put(1,"123");
        map.put(1, "1234");
        for (Integer key : map.keySet()){
            System.out.println(map.get(key));
        }
    }
}
