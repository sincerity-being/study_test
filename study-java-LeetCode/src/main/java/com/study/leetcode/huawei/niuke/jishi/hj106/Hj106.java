package com.study.leetcode.enterprise.huawei.niuke.jishi.hj106;

import java.util.Scanner;
/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 17:31
 * @describe 字符逆序!!!
 */

public class Hj106{
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        while(in.hasNextLine()){
            String li = in.nextLine();
            char[] liArr = li.toCharArray();
            int len = liArr.length;
            StringBuilder builder = new StringBuilder();
            for(int i=0;i<len;i++){
                builder.append(liArr[len-i-1]);
            }
            System.out.println(builder);
        }
    }
}
