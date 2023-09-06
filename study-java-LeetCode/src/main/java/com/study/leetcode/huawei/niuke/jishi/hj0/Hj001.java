package com.study.leetcode.enterprise.huawei.niuke.jishi.hj0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 19:26
 * @describe
 */

/**
 * java编程 输入任意的数（不超过1000000）
 * 将其分解成两个质数相加的形式，
 * 输出总共有多少总分解方式，分解因子不区分排序
 * example
 * input 100
 * 俩质数相加=100
 * 100=3+97
 * 100=11+89
 * 100=17+83
 * 100=29+71
 * 100=41+59
 * 100=47+53
 * output 6
 */
public class Hj001 {

    public static void main(String[] args) {
        String str = "" ;
        str.substring(0);

        System.out.println("请输入数字：");
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>() ;

        int nextInt = in.nextInt();
        if(nextInt!= 0){
            list.add(nextInt);
        }
        while(nextInt!=0){
            System.out.println("请输入数字：");
            int nextInt2 = in.nextInt();
            if (nextInt2 != 0) {
                list.add(nextInt2);
            }
            nextInt = nextInt2 ;
        }
        for (Integer integer : list) {
            System.out.println(get(integer));
        }
        System.out.println("end");
    }
    public static int get(Integer num){
        int all = 0 ;
        for(int i = 2 ; i <= num/2 ; i ++ ){
            if(prime(i)&&prime(num-i)){
                all = all + 1 ;
                System.out.println(num + "=" + i + "+" + (num-i));
            }
        }
        return all;
    }

    /**
     * 1 不是 质数
     * @param num
     * @return
     */
    public static boolean prime(int num){
        boolean flag = true ;
        double sqrt = Math.sqrt(num);
        if(num == 2 || num ==3){

        }else{
            for(int i = 2 ; i <= sqrt; i++){
                if(num%i==0){
                    flag=false ;
                    break ;
                }
            }
        }
        return flag ;

    }
}
