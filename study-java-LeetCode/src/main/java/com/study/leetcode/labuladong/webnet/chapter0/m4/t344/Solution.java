package com.study.leetcode.labuladong.webnet.chapter0.m4.t344;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 12:37
 * @describe https://leetcode.cn/problems/reverse-string/description/
 * 344. 反转字符串
 */
public class Solution {

    public void reverseString(char[] s) {
         int left = 0, right = s.length - 1;
         while (left < right) {
             char temp = s[left];
             s[left] = s[right];
             s[right] = temp;
             left ++;
             right --;
         }
    }

}
