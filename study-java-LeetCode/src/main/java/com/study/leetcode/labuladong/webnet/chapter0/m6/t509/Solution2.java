package com.study.leetcode.labuladong.webnet.chapter0.m6.t509;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 23:19
 * @describe
 */
public class Solution2 {


    public int fib(int n) {
        int[] memo = new  int[n + 1];
        return dp(memo, n);
    }

    public int dp(int[] memo, int n) {
        if (n == 0 || n == 1) return n;
        if ( memo[n] != 0) {
            return memo[n];
        }
        memo[n] = dp(memo, n-1) + dp(memo, n-2);
        return memo[n];
    }
}
