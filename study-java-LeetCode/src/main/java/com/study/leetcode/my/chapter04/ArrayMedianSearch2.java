package com.study.leetcode.my.chapter04;/**
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
public class ArrayMedianSearch2 {

    public static void main(String[] args) {
       int[] nums1 = new int[]{1};
       int[] nums2 = new int[]{2, 3};
        double v = findMiddleNumInSortedArray(nums1, nums2);
        log.info("v:{}",v);
    }

    public static double findMiddleNumInSortedArray(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1 + len2;
        // 1)
        if (totalLen % 2 == 1){
            return getMiddleNum(nums1, nums2, totalLen / 2 + 1);
        }else {
            return ((getMiddleNum(nums1, nums2, totalLen / 2) + getMiddleNum(nums1, nums2, totalLen / 2 + 1)) / 2.0);
        }
    }

    /**
     * 注意一个问题 索引就是索引 k 就是表示第几个数,而非索引, 所以
     * 在具体使用索引去获取某个数 要 注意这个问题.
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static int getMiddleNum(int[] nums1, int[] nums2, int k){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;

        while(true){

            // 1)
            if(index1 == len1){
                return nums2[index2 + k - 1];
            }

            if (index2 == len2){
                return nums1[index1 + k -1];
            }

            // 当 k == 1 时 index1 + k - 1 = index1 index2 + k - 1 = index2
            if (k == 1){
                return Math.min(nums1[index1 + k - 1], nums2[index2 + k - 1]);
            }

            int half = k / 2 ;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pv1 = nums1[newIndex1];
            int pv2 = nums2[newIndex2];
            if (pv1 <= pv2){
                k -= (newIndex1 - index1 + 1);
                // 从多一个索引处检索
                index1 = newIndex1 + 1;
            }else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }



    }

}
