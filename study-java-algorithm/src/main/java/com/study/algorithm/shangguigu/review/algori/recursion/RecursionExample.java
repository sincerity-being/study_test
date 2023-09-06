package com.study.algorithm.shangguigu.review.algori.recursion;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-13 19:48
 * @describe
 */
public class RecursionExample {

    public static void main(String[] args) {
           int res = factorial(3);
           System.out.println("res=" + res);
    }


    /**
     * 阶乘问题
     *
     */
    public static int factorial(int n){
        if(n == 1){
            return 1;
        }else {
            return factorial(n-1) * n;
        }
    }


}
