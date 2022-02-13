package com.study.leetcode.random.let.array.sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-17 09:32
 * @describe
 */
public class SumDemoUpdate {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>(16);
        System.out.println(map.get(6));

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 17;
        int[] res = twoSum(nums, target);
        if (!Objects.isNull(res)){
            System.out.println("res===" + res[0]+res[1]);
        }
    }

    /**
     * 存的是互补的数
     * @param nums nums
     * @param target 目标
     * @return 结果数组
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length ; i++) {
            Integer key = target -nums[i];
          if (map.containsKey(key)){
              res[0] = map.get(key);
              res[1] = i;
              return res;
          }else{
              map.put(nums[i],i);
          }
        }

        return  null;
    }
}
