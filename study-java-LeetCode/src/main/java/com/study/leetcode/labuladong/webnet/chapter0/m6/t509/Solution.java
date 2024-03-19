package com.study.leetcode.labuladong.webnet.chapter0.m6.t509;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 22:07
 * @describe https://leetcode.cn/problems/fibonacci-number/description/
 */
public class Solution {

    public int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }


}
