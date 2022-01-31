package com.study.basic.array;

import java.util.Arrays;
import java.util.Random;
import static com.study.basic.util.Print.*;
/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-01-31 22:04
 * @describe thinking in java -- chapter05
 */
public class ArrayClassObj {

    public static void main(String[] args) {
        Random random = new Random(47);
        Integer[] a = new Integer[random.nextInt(20)];
        print("length of a = " + a.length);
        for (int i = 0; i <  a.length; i++) {
            // Autoboxing 自动泛型
            a[i] = random.nextInt(500);
        }
        print(Arrays.toString(a));
    }
}
