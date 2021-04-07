package com.java.st.array.sum;

import java.util.Objects;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-17 09:22
 * @describe 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumDemo {

    public static void main(String[] args) {
       int[] nums = new int[]{2, 7, 11, 15};
       int target = 17;
      int[] res = twoSum(nums, target);
      if (!Objects.isNull(res)){
          System.out.println("res===" + res[0]+res[1]);
      }

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // 数组就是 遍历
        for(int i = 0; i < nums.length; i ++){
            // 一个数组搞成双层遍历
            for(int j = i +1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return  null;
    }
}
