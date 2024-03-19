package com.study.leetcode.xiechen.niuke.e1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-13 23:38
 * @describe
 */
import java.util.Scanner;

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Solution_1 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            int n = Integer.parseInt(in.next());
            int[] arr = new int[n];
            for(int i = 1; i <= n; i++ ){
                arr[i-1] = i;
            }

            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>(10);
            int count = 0;
            for(int i = 0; i < n; i++) {
                int temp = arr[i];
                set.add(temp);
                list.add(temp);

                for (int j = 0; j < n; j++) {
                    if (!set.contains(arr[j])) {
                        if (!isPrime(list.get(list.size()-1) + arr[j])){
                            set.add(arr[j]);
                            list.add(arr[j]);
                            j = -1;
                        }
                    }
                }
                if (list.size() == n){
                    count ++;
                }
                set.clear();
                list.clear();

            }
            System.out.println(count);
        }


        public static boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
