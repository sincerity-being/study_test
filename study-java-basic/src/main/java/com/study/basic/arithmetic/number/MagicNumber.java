package com.study.basic.arithmetic.number;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import java.util.Arrays;

/**
 * 注释..
 * <p>  </p>
 *
 * @author 何裕墙  heyuqiang@kungeek.com
 * @since 1.0
 */
public class MagicNumber {

     public static void selectMagicNumber() {
         String[] ar_str1, ar_str2;
         int sum = 0;
         int from;
         int to;
         int i_val;
         int count = 0;
         for (int i = 10; i < 100; i++) {
             from = Math.max(1000 / i, i + 1);
             to = 100;
             for (int j = from; j < to; j++) {
                 i_val = i * j;
                 /**
                  * 假设val = 1000a + 100b + 10c + d, 因为满足val = x * y, 则有x = 10a + b, y = 10c + d
                  * 则val - x - y = 990a + 99b + 9c = 9 * (110a + 11b + c), 所以val - x - y能被9整除。
                  * 所以满足该条件的数字必定能被9整除，所以可以直接过滤其他数字。
                  * 并且以两个0结尾的数字不允许的.
                  */
                 if (i_val % 100 == 0 || (i_val - i - j) % 9 != 0) {
                     continue;
                 }
                 count++;
                 ar_str1 = String.valueOf(i_val).split("");
                 ar_str2 = (i + String.valueOf(j)).split("");
                 Arrays.sort(ar_str1);
                 Arrays.sort(ar_str2);
                 // 排序后比较,为真则找到一组
                 if (Arrays.equals(ar_str1, ar_str2)) {
                     sum++;
                     System.out.println("第" + sum + "组: " + i + "*" + j + "=" + i_val);
                 }
             }
         }
         System.out.println("共找到" + sum + "组吸血鬼数");
         System.out.println(count);
     }

    public static void main(String[] args) {
        selectMagicNumber();
    }
}
