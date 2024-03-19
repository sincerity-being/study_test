package com.study.leetcode.labuladong.webnet.chapter0.m4.t167;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 12:27
 * @describe
 */
public class Solution1 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new  int[]{left + 1, right + 1};
            }else if (sum < target) {
                left++;
            } else {
                right --;
            }

        }
        return new int[]{-1, -1};
    }
}
