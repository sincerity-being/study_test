package com.study.leetcode.enterprise.huawei.niuke.jishi.hj75;

import java.util.Scanner;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 22:15
 * @describe 公共子串计算-- 动态规划
 */
public class Hj75{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            // TODO  1. 输入2个字符串
            String str1 = sc.next();
            String str2 = sc.next();

            // TODO  2. 转换为字符数组
            char[] c1 = str1.toCharArray();
            char[] c2 = str2.toCharArray();

            // TODO 3. 构建dp数组
            int[][] dp = new int[c1.length + 1][c2.length + 1];

            // TODO 4. 处理边界问题和初始值
            for (int i = 0; i <= c1.length; i++) {
                dp[i][0] = 0;
            }
            for (int j = 0; j <= c2.length; j++) {
                dp[0][j] = 0;
            }
            int res = 0;  // 定义一个结果来保存最长子串
            // TODO 5. 填充数组其余值
            for (int i = 1; i <= c1.length; i++) {
                for (int j = 1; j <= c2.length; j++) {
                    // TODO 6. 逐一对比每个字符
                    if (c1[i-1] == c2[j-1]){ //因为 c1.c2 是从0开始存字符的
                        // TODO 7. 相等则用不包含该字符的上一个最优解去 + 1
                        dp[i][j] = dp[i-1][j-1] +1;

                    }else {
                        dp[i][j] = 0;
                    }
                    res = Math.max(res,dp[i][j]);
                }
            }
            System.out.println(res);

        }

    }
}
