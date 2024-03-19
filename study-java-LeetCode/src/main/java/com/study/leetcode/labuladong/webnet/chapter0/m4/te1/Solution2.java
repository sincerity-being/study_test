package com.study.leetcode.labuladong.webnet.chapter0.m4.te1;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 11:35
 * @describe
 */
public class Solution2 {

    public int binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return  mid;
            } else if (nums[mid] > target) {
                left = mid + 1;
            }else if (nums[mid] < target) {
                right = mid - 1;
            }
        }
        return -1;
    }

}
