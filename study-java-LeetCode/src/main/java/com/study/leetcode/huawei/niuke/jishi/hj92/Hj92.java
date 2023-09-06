package com.study.leetcode.enterprise.huawei.niuke.jishi.hj92;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 18:44
 * @describe 在字符串中找出连续最长的数字串
 */
import java.util.*;
public class Hj92 {
    public static void main(String[] args) {
        fun1();
    }



    private static void fun1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int len = str.length();
            int[] dp = new int[len+1];
            int res = 0;
            for (int i =1; i <= len; i++) {
                char tmp = str.charAt(i-1);
                if (tmp >= '0' && tmp <= '9') {
                    dp[i] = dp[i-1] +1;
                    res = Math.max(res, dp[i]);
                }
            }

            for (int i =1; i<= len; i++) {
                if (dp[i] == res) {
                    System.out.print(str.substring(i - res, i));
                }
            }
            System.out.println("," + res);
        }
    }

    private static void fun2(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] ss = line.split("[^0-9]+");
            int max  = 0;
            ArrayList<String> list = new ArrayList<>();
            for(String s : ss){
                if(s.length() > max){
                    max = s.length();
                    list.clear();
                    list.add(s);
                }else if(s.length() == max){
                    max = s.length();
                    list.add(s);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(String item : list){
                sb.append(item);
            }
            sb.append(",").append(max);
            System.out.println(sb.toString());
        }
    }
}

