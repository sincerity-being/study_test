package com.study.leetcode.labuladong.webnet.chapter0.m6.t509;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 23:09
 * @describe
 */
public class Solution1 {

    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 2 || N == 1) return 1;
        return fib(N - 1) + fib(N - 2);
    }

}
