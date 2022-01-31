package com.study.leetcode.algorithm.st.array.intersection;

import java.util.Arrays;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-16 20:43
 *@describe:两个数组的交集 II
 *
     给定两个数组，编写一个函数来计算它们的交集。

    示例 1:
    输入: nums1 = [1,2,2,1], nums2 = [2,2]
    输出: [2,2]

    示例 2:
    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出: [4,9]

    说明：
    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
    我们可以不考虑输出结果的顺序。

    进阶:

    如果给定的数组已经排好序呢？你将如何优化你的算法？
    如果 nums1 的大小比 nums2 小很多，哪种方法更优？
    如果 nums2的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 *@version:
 */
public class Function1 {


    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        int[] c = {2};
        int[] d = {6, 6, 4, 4, 0, 0, 8, 1, 2};
        int[] e = {6};
//        System.out.println(Arrays.toString(new Function1().intersect(a, b)));
//        System.out.println(Arrays.toString(new Function1().intersect(a, c)));
        System.out.println(Arrays.toString(new Function1().intersect(d, e)));
    }

    /***
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        //交集长度一定不会超过长度较小的那个数组的长度,没有用ArrayList这些可变数组是因为他们很浪费空间
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int i : nums1) {
            for (int j = 0; j < nums2.length; j++) {
                if (i == nums2[j]) {
                    result[index++] = nums2[j];
           //万一数组中会出现-1，那我们这种做法就是错误的
                    nums2[j] = -1;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index );
    }


}
