package com.study.leetcode.algorithm.st.array.intersection;

import java.util.Arrays;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-16 20:54
 *@describe:
 *@version:
 */
public class Function3 {


    /**
     *
     * @param args
     */
    public static void main(String[] args) {

    }
    /***
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

}
