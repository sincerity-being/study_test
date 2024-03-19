package com.study.leetcode.labuladong.webnet.chapter0.m4.te2;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 12:43
 * @describe 首先明确一下，回文串就是正着读和反着读都一样的字符串。
 * 比如说字符串 aba 和 abba 都是回文串，因为它们对称，反过来还是和本身一样；反之，字符串 abac 就不是回文串。
 */
public class Solution {
    boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            right --;
            left ++;
        }
        return true;
    }


}
