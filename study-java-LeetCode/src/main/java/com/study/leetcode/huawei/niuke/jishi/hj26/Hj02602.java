package com.study.leetcode.enterprise.huawei.niuke.jishi.hj26;

import java.util.Scanner;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-07 10:01
 * @describe 找出一个字符串中 大写字母 eg: A 1 0 1 1150175017(&^%&$vabovbaoadd 123#$%#%#O
 */
public class Hj02602 {


    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String str = sc.nextLine();
         int count = 0;
         char[] strArray = str.toCharArray();
         for (int i = 0 ; i < strArray.length; i++){
             if ('A' <= strArray[i] && strArray[i] <= 'Z'){
                 count ++;
             }
         }
        System.out.println(count);
    }






}
