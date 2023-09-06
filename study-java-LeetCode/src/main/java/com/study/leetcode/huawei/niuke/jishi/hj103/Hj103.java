package com.study.leetcode.enterprise.huawei.niuke.jishi.hj103;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 18:25
 * @describe Redraiment走法---> 暴力动态规划!!!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hj103 {
    public static int count(int []nums){
        int []dp = new int[nums.length];
        //初始化为1
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 1;i < nums.length;++i){
            for(int j = 0;j < i;++j){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
                max = Math.max(dp[i],max);
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = bf.readLine()) != null){
            int len = Integer.parseInt(str);
            int[] nums = new int[len];
            String[] split = bf.readLine().split(" ");
            for(int i = 0;i < len;++i){
                nums[i] = Integer.parseInt(split[i]);
            }
            System.out.println(count(nums));
        }
    }
}

