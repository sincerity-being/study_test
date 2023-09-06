package com.study.leetcode.enterprise.huawei.niuke.jishi.hj0;

import java.util.Arrays;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 21:27
 * @describe  从1 2 3 4 取出 3个 组成不重复的三位数
 */
public class Hj003 {

    public static void main(String[] args) {
        fun0();
    }

    private static void fun0() {
        int count = 0;
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.size(); k++) {
                    if (!list.get(i).equals(list.get(j)) &&
                            !list.get(i).equals(list.get(k)) && !list.get(j).equals(list.get(k))) {
                        System.out.println(list.get(i).toString() + list.get(j).toString() + list.get(k));
                        count++;
                    }
                }
            }
        }
        System.out.println("count==" + count);
    }

    private static void fun() {
        int count = 0;
        List<Integer> list = Arrays.asList(1,2,3,4);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++){
                for (Integer integer : list) {
                    System.out.println(list.get(i).toString() + list.get(j).toString() + integer.toString());
                    count++;
                }
            }
        }
        System.out.println("count==" + count);
    }
}
