package com.study.leetcode.huawei.niuke.jishi.hj108;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 17:10
 * @describe 求最小公被数
 */
import java.util.Scanner;

public class Hj108 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int lcm = a*b / gcd(a,b);
            System.out.println(lcm);
        }
    }

    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
