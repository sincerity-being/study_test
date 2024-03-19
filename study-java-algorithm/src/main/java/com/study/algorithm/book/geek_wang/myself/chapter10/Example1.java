package com.study.algorithm.book.geek_wang.myself.chapter10;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2023-09-11 15:04
 * @describe
 */
public class Example1 {

    int f(int n) {
        int ret = 1;
        for (int i = 2; i <= n; ++i) {
            ret = ret + 1;
        }
        return ret;
    }


    int f1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }
}
