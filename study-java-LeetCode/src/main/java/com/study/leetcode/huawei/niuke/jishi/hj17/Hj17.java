package com.study.leetcode.enterprise.huawei.niuke.jishi.hj17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 20:50
 * @describe 坐标移动 正则
 */
public class Hj17{
    public static void main(String[] args) {
        fun1();
    }


    private static void fun2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] in = bf.readLine().split(";");
        int x = 0;
        int y = 0;
        for(String s : in){
            // 不满足题目给定坐标规则
            if(!s.matches("[WASD][0-9]{1,2}")){
                continue;
            }
            int val = Integer.parseInt(s.substring(1));
            switch(s.charAt(0)){
                case 'W':
                    y += val;
                    break;
                case 'S':
                    y -= val;
                    break;
                case 'A':
                    x -= val;
                    break;
                case 'D':
                    x += val;
                    break;
            }
        }
        System.out.println(x+","+y);
    }

    private static void fun1() {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            int x = 0 , y = 0;
            String[] sArray = s.split(";");
            String res = "[ADWS]\\d{1}\\d?";
            for (String value : sArray) {
                if (value.matches(res))
                    map.put(value.charAt(0), map.getOrDefault(value.charAt(0), 0)
                            + Integer.parseInt(value.substring(1)));
            }
            x = x - map.get('A') + map.get('D');
            y = y - map.get('S') + map.get('W');
            System.out.println(x+","+y);
            map.clear();
        }
        scanner.close();
    }
}
