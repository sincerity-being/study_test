package com.study.leetcode.enterprise.huawei.niuke.jishi.hj1;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/exam/oj/ta?tpId=37
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 17:53
 * @describe
 */
public class Hj01 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" "); //正则表达式实用性更强( str.split("\\s+"))
        int length = s[s.length - 1].length();
        System.out.println(length);
    }
}
