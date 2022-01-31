package com.java.st.array.searchMiddle;/**
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
public class Solution2 {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,6,7};
        int[] num2 = new int[]{2,3};
        double middleInSortedArrays = findMiddleInSortedArrays(num1, num2);
        log.info("middleInSortedArrays: {}" ,middleInSortedArrays);
    }


    public static int getMiddleNum(int[] num1, int[] num2, int k) {
         int index1 = 0 ;
         int index2 = 0;
         int length1 = num1.length;
         int length2 = num2.length;

         // 注意循环中有递归 找到递归跳出递归的条件
         while(true){

             // 三种特殊情况
             //1) 数组1 到了length1处 数组1 已经遍历完了,故中位数,不可能在这个地方.数组越界.
            if (index1 == length1){
                return num2[index2 + k - 1];
            }

            // 2)
            if (index2 == length2){
                return  num1[index1 + k - 1];
            }

            // 3)
             if (k == 1){
                 return Math.min(num1[index1], num2[index2]);
             }

             // 正常情况
             int half = k / 2 ;
             int newIndex1 = Math.min(index1 + half , length1) - 1;
             int newIndex2 = Math.min(index2 + half , length2) - 1;
             int pov1 = num1[newIndex1];
             int pov2 = num2[newIndex2];
             if (pov1 <= pov2){
                 //java.lang.ArrayIndexOutOfBoundsException: -2
              //   k -= k + index1 - newIndex1 + 1;
                 k -= (newIndex1 - index1 + 1);
                 index1 = newIndex1 + 1;
             }else {
               //  k -= k + index2 - newIndex2 + 1;
                 k -= (newIndex2 - index2 + 1);
                 index2 = newIndex2 + 1;
             }

         }

    }

    public  static double findMiddleInSortedArrays(int[] num1, int[] num2){
        // 为简化计算, 当两个数组的长度为奇数时, 那个中位数就是 (num1.length + num2.length) / 2 + 1;
        // 而当连个数组的长度之和为偶数时, 那个中位数就是(num1.length + num2.length)/ 2
        // 以及 (num1.length + num2.length) / 2 + 1 两数之和/ 2;
        // 现在可以找到
        int num1Length = num1.length;
        int num2Length = num2.length;
        int totalLength = num1Length + num2Length;
        double minNumber = 0.0D;
        if (totalLength % 2 == 1){
            // 表明符合第一种情况
             minNumber = getMiddleNum(num1, num2, totalLength / 2 + 1);
        }else{
            // 符合第二种情况.
            minNumber = (getMiddleNum(num1, num2, totalLength / 2) +
                    getMiddleNum(num1, num2, totalLength / 2 + 1)) / 2.0;
        }
        return minNumber;
    }


}
