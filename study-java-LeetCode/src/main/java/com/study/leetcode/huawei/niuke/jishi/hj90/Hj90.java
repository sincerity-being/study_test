package com.study.leetcode.enterprise.huawei.niuke.jishi.hj90;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 18:00
 * @describe 合法ip
 */
import java.util.*;
public class Hj90 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] strs = scan.nextLine().split("\\.");
        if (strs.length != 4) {
            System.out.println("NO");
            return;
        }
        for (String str : strs) {
            if ("".equals(str)) {
                System.out.println("NO");
                return;
            }
            int tmp = 0;
            try {
                tmp = Integer.parseInt(str);
            } catch (Exception e) {
                System.out.println("NO");
                return;
            }
            if (tmp < 0 || tmp > 255) {
                System.out.println("NO");
                return;
            }
            if (String.valueOf(tmp).length() != str.length()) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}

