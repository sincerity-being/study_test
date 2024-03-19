package com.study.leetcode.labuladong.webnet.chapter0.m4.t26;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 09:34
 * @describe https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
            if (nums.length == 0){
                return 0;
            }
            int fast = 0, slow = 0;
            while (fast < nums.length){
                if (nums[fast] != nums[slow]){
                    slow ++;
                    nums[slow] = nums[fast];
                }
                fast ++;
            }
            return slow + 1;
    }

}
