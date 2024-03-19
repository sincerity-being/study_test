package com.study.leetcode.labuladong.webnet.chapter0.m4.t283;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 10:51
 * @describe https://leetcode.cn/problems/move-zeroes/description/
 * 移动零
 */
public class Solution {

    public void moveZeroes(int[] nums) {
          // 第一步 删除 是0 的元素!
        int slow = removeElement(nums, 0);
        // 第二步, 剩余元素为0
        for (int k = slow; k < nums.length; k++){
            nums[k] = 0;
        }
    }


    private int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0, slow = 0;

        while(fast < nums.length) {

            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow ++;
            }

            fast ++;
        }
        return slow;
    }
}
