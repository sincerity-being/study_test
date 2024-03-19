package com.study.algorithm.book.geek_wang.myself.chapter06;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-03 11:15
 * @describe
 */
public class ListReverse {

    public static void main(String[] args) {
        List<Integer> originArray = new ArrayList<>(10);
        originArray.add(1);
        originArray.add(2);
        originArray.add(3);
        originArray.add(4);
        originArray.add(5);
        originArray.add(6);
        originArray.add(7);

        reverseList(originArray);

        System.out.println("reverseList" + originArray);

    }

    private static void reverseList(List<Integer> originArray) {
        Stack<Integer> stack = new Stack<>();

        for (Integer num : originArray) {
            stack.push(num);
        }

        originArray.replaceAll(ignored -> stack.pop());

    }

}
