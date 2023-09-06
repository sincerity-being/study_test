package com.study.leetcode.enterprise.huawei.niuke.jishi.hj26;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 22:57
 * @describe
 */
public class Hj26 {

    public static void main(String[] args) {
        fun2();

    }


    /**
     *  冒泡又会出现难解决的其他字母不排序. 选择排序又会出现不稳定
     *  解决矛盾点; 字母以及其他的字符进行分离. 先对字母排好序 在进行合并!!!--- 妙手!
     */
    private static void fun2() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char temp ;
        int ic = 0;
        int jc = 0;
        char[] strArray = str.toCharArray();

        char[] ziMu = new char[strArray.length];

        // 字母数组有效长度
        int count = 0;
        // 搜集字母
        for (int i = 0; i < strArray.length; i++){
             if (isZimu(strArray[i])){
                 ziMu[count++] = strArray[i];
             }
        }
        System.out.println(ziMu);

        for (int i = 0; i < count; i++){
            for(int j = 1; j < count-i; j++){
                if ('A' <= ziMu[j-1] &&  ziMu[j-1] <= 'Z'){
                    ic = ziMu[j-1] + 32;
                }else{
                        ic = ziMu[j-1];
                }
                if ('A' <= ziMu[j] &&  ziMu[j] <= 'Z'){
                    jc = ziMu[j] + 32;
                }else{
                    jc = ziMu[j];
                }
                if (ic > jc) {
                    temp = ziMu[j - 1];
                    ziMu[j - 1] = ziMu[j];
                    ziMu[j] = temp;
                }
            }
        }
        System.out.println(ziMu);
        int t = 0;
       StringBuilder builder = new StringBuilder();
       for (int i = 0; i < strArray.length; i++){
           if (isZimu(strArray[i])){
               builder.append(ziMu[t++]);
           }else{
               builder.append(strArray[i]);
           }
       }

        System.out.println(builder.toString());

    }

    /**
     * 方法1 排序会出现不稳定性!!
     */
    private static void fun1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char temp ;
        int ic = 0;
        int jc = 0;
        char[] strArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++){
            for(int j = i+1; j < str.length(); j++){
                if (isZimu(strArray[i]) && isZimu(strArray[j])){
                    if ('A' <= strArray[i] &&  strArray[i] <= 'Z'){
                        ic = strArray[i] + 32;
                    }else{
                        ic = strArray[i];
                    }
                    if ('A' <= strArray[j] &&  strArray[j] <= 'Z'){
                        jc = strArray[j] + 32;
                    }else{
                        jc = strArray[j];
                    }
                    if (ic > jc){
                        temp = strArray[i];
                        strArray[i] = strArray[j];
                        strArray[j] = temp;

                    }
                }
            }
        }

        System.out.println(strArray);
    }

    /**
     * 冒泡又会出现难解决的其他字母不排序.
     */
    private static void fun() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char temp ;
        int ic = 0;
        int jc = 0;
        char[] strArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++){
            for(int j = 1; j < str.length()-i; j++){
                if (isZimu(strArray[j-1]) && isZimu(strArray[j])){
                    if ('A' <= strArray[j-1] &&  strArray[j-1] <= 'Z'){
                        ic = strArray[j-1] + 32;
                    }else{
                        ic = strArray[j-1];
                    }
                    if ('A' <= strArray[j] &&  strArray[j] <= 'Z'){
                        jc = strArray[j] + 32;
                    }else{
                        jc = strArray[j];
                    }
                     if (ic > jc){
                         temp = strArray[j-1];
                         strArray[j-1] = strArray[j];
                         strArray[j] = temp;

                     }
                }
            }
        }

        System.out.println(strArray);
    }

    private  static boolean isZimu(char c){
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
}
