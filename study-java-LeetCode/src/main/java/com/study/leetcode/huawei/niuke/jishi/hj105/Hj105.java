package com.study.leetcode.enterprise.huawei.niuke.jishi.hj105;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 17:46
 * @describe 记负均正II
 */
import java.util.Scanner;
public class Hj105{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float count1 = 0;
        int count2 = 0;
        float sum = 0;
        while (sc.hasNextInt()){
            int cur = sc.nextInt();
            if (cur >= 0){
                count1++;
                sum += cur;
            }else{
                count2++;
            }
        }
        System.out.println(count2);
        System.out.printf("%.1f\n", sum/count1);
    }
}
