package com.study.leetcode.enterprise.didi.let;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-10 13:01
 * @describe
 * 给定三种类型的小球 P、Q、R，每种小球的数量分别为 np、nq、nr 个。现在想将这些小球排成一条直线，
 * 但是不允许相同类型的小球相邻，问有多少种排列方法
 *
 *输入：2 1 1
 * 输出：6
 * 解释：如若 np=2，nq=1，nr=1 则共有 6 种排列方式：PQRP，QPRP，PRQP，RPQP，PRPQ 以及 PQPR。
 */
public class ArrangeSmallBall {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int np = Integer.parseInt(params[0]);
        int nq = Integer.parseInt(params[1]);
        int nr = Integer.parseInt(params[2]);
        HashMap<String, Long> mem = new HashMap<>(16);
        System.out.println(dfs("", np, nq, nr, mem));
    }

    private static long dfs(String prev, int p, int q, int r, HashMap<String, Long> mem) {
        if (p < 0 || q < 0 || r < 0) {
            return 0;
        }
        if (mem.containsKey(prev + ":" + p + " " + q + " " + r)) {
            return mem.get(prev + ":" + p + " " + q + " " + r);
        }
        if (p == 0 && q == 0 && r == 0) {
            return 1;
        } else {
            long res = 0L;
            switch (prev) {
                case "":
                    res = dfs("P", p - 1, q, r, mem) + dfs("Q", p, q - 1, r, mem) + dfs("R", p, q, r - 1, mem);
                    break;
                case "P":
                    res = dfs("Q", p, q - 1, r, mem) + dfs("R", p, q, r - 1, mem);
                    break;
                case "Q":
                    res = dfs("P", p - 1, q, r, mem) + dfs("R", p, q, r - 1, mem);
                    break;
                case "R":
                    res = dfs("P", p - 1, q, r, mem) + dfs("Q", p, q - 1, r, mem);
                    break;
            }
            mem.put(prev + ":" + p + " " + q + " " + r, res);
            return res;
        }
    }

}
