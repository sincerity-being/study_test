package com.java.my.chapter04;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 *
 * </pre>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
@Slf4j
public class ArrayMedianSearch {

    /**
     * 二分查找法 不断缩小区间
     *
     * 方法1: 暴力求解
     * 1) 先合并两个有序数组
     * 2) 然后排序找到中位数
     * 3)没有使用到数组有序这一条件
     *
     * 方法2 合并两个有序数组
     * 1) 借鉴归并排序的关键步骤(合并两个有序数组),将时间复杂度降低到O(m+n)
     * 2) 后面部分与暴力法一样.
     * 注意: 也可以不用合并完,也可得出,但不会降低时间复杂度.
     */

     public static double findMiddleNumInSortArray(int[] nums1, int[] nums2){
         int length1 = nums1.length;
         int length2 = nums2.length;
         int totalLength = length1 + length2;
         // 1) 奇数
         if ( (totalLength % 2) == 1){
             return getMiddleNum(nums1, nums2, totalLength / 2 + 1);
         }else{
             return ((getMiddleNum(nums1, nums2, totalLength / 2) + getMiddleNum(nums1, nums2, totalLength / 2 + 1)) / 2.0);
         }
     }


     public static int getMiddleNum(int[] nums1, int[] nums2, int k){
             int index1 = 0;
             int index2 = 0;
             int length1 = nums1.length;
             int length2 = nums2.length;

            while (true){
                // 三种不正常的情况
                if (index1 == length1){
                    // 最简单的想法来理解
                    return nums2[index2 + k - 1];
                }

                if (index2 == length2){
                    return nums1[index1 + k - 1];
                }

                if(k == 1){
                    return Math.min( nums1[index1], nums2 [index2]);
                }

                // 正常情况
                int half = k / 2;

                int newIndex1 = Math.min(index1 + half, length1) - 1 ;
                int newIndex2 = Math.min(index2 + half, length2) - 1;
                int pv1 = nums1[newIndex1];
                int pv2 = nums2[newIndex2];
                if (pv1 <= pv2){
                    k -= (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                }else{
                    k -= (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }

            }
     }

    public static void main(String[] args) {
         int[] nums1 = new int[]{1};
         int[] nums2 = new int[]{2, 3};
         double v = findMiddleNumInSortArray(nums1, nums2);
         log.info("v:{}",v);
    }


}
