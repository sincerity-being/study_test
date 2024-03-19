package com.study.leetcode.labuladong.webnet.chapter0.m4.t5;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 14:13
 * @describe
 */
public class Solution1 {

    public String longestPalindrome(String s) {
        String res = "";
        for(int k = 0; k < s.length(); k++){
            String s1 = palindrome(s, k, k);
            String s2 = palindrome(s, k, k+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    String palindrome(String s, int l, int r) {

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l --;
            r ++;
        }
        return  s.substring(l + 1, r);
    }
}
