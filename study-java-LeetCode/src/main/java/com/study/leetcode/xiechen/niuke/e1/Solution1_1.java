package com.study.leetcode.xiechen.niuke.e1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Solution1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = Integer.parseInt(in.next());
        int[] arr = new int[n];
        Map<Integer, Boolean> hashmap = new HashMap<>(16);
        for(int i = 1; i <= n; i++ ){
            arr[i-1] = i;
            hashmap.put(i, false);
        }


        List<Integer> list = new ArrayList<>(10);
        int count = 0;
        for(int i = 0; i < n; i++) {
            int temp = arr[i];
            list.add(temp);
            hashmap.put(arr[i], true);
            for (int j = 0; j < n; j++){
                if (! hashmap.get(arr[j])){
                    if (!isPrime(list.get(list.size()-1) + arr[j])){
                        hashmap.put(arr[j], true);
                        list.add(arr[j]);
                        j = -1;
                    }
                }
            }


            if (list.size() == n){
                count ++;
            }

            list.clear();
            for(int k = 1; k <= n; k++ ){
                hashmap.put(k, false);
            }


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
