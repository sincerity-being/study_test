package com.study.leetcode.mydailytopic.let.chapter01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-10 12:52
 * @describe
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 17;
        int[] res = twoSum(nums, target);
        System.out.println("res=" + res[0] + res[1]);
    }

    public static int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>(16);
         for(int i = 0; i < nums.length; i++){
             Integer key = target - nums[i];
             if (map.containsKey(key)){
                 res[0] = map.get(key);
                 res[1] = i;
                 return res;
             }else {
                 map.put(nums[i], i);
             }
         }
         return null;
    }

}
