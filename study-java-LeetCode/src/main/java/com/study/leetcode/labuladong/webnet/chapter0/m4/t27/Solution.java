package com.study.leetcode.labuladong.webnet.chapter0.m4.t27;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 10:38
 * @describe https://leetcode.cn/problems/remove-element/description/
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            }
            int fast = 0; int slow = 0;
            while (fast < nums.length) {

                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow ++;
                }
                fast ++;
            }
            return slow;
    }


}
