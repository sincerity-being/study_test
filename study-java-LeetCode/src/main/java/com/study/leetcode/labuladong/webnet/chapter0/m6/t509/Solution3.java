package com.study.leetcode.labuladong.webnet.chapter0.m6.t509;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 23:33
 * @describe
 */
public class Solution3 {

    int fib(int N) {
        if (N == 0) return 0;
        int[] dp = new int[N + 1];
        // base case
        dp[0] = 0; dp[1] = 1;
        // 状态转移
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }

}
