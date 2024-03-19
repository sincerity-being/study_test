package com.study.algorithm.book.geek_wang.myself.chapter10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2023-09-11 14:53
 * @describe
 */
public class Example {

    Map<Integer,Integer> hasSolvedList = new HashMap<>(16);

    // 全局变量，表示递归的深度。
    int depth = 0;

   // f(n)=f(n-1)+1 其中，f(1)=1
   public int f(int n) {
       if (n == 1) return 1;
       return f(n-1) + 1;
   }


    /**
     * f(1) = 1;
     * f(2) = 2;
     * f(n) = f(n-1)+f(n-2)
     */
   public  int f1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f1(n-1) + f1(n-2);
    }




    int f2(int n) throws Exception {
        ++depth;
        if (depth > 1000) throw new Exception();

        if (n == 1) return 1;
        return f2(n-1) + 1;
    }

    public int f3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        // hasSolvedList可以理解成一个Map，key是n，value是f(n)
        if (hasSolvedList.containsKey(n)) {
            return hasSolvedList.get(n);
        }

        int ret = f3(n-1) + f3(n-2);
        hasSolvedList.put(n, ret);
        return ret;
    }

}
