package com.study.leetcode.labuladong.webnet.chapter0.m4.t26;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 10:11
 * @describe
 */
public class Solution2 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0; int fast = 0;

        while (fast < nums.length){

            if (nums[slow] != nums[fast]){
                  slow ++;
                  nums[slow] = nums[fast];
            }
            fast ++;
        }
        return slow + 1;
    }
}
