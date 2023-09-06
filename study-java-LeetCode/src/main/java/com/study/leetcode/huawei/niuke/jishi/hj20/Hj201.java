package com.study.leetcode.enterprise.huawei.niuke.jishi.hj20;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 21:25
 * @describe
 */
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Hj201 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String mima = in.nextLine();
            if(isLengthOk(mima) && contains3Type(mima) && !containsRepeat3(mima)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
    public static boolean isLengthOk(String s){
        return s.length() > 8;
    }
    public static int containsUpperLetter(String s){
        for(Character c : s.toCharArray()){
            if(Character.isUpperCase(c)){
                return 1;
            }
        }
        return 0;
    }
    public static int containsLowerLetter(String s){
        for(Character c : s.toCharArray()){
            if(Character.isLowerCase(c)){
                return 1;
            }
        }
        return 0;
    }
    public static int containsDigit(String s){
        for(Character c : s.toCharArray()){
            if(Character.isDigit(c)){
                return 1;
            }
        }
        return 0;
    }
    public static int containsOther(String s){
        for(Character c : s.toCharArray()){
            if(!Character.isLetterOrDigit(c)){//不是字母或数字
                return 1;
            }
        }
        return 0;
    }
    public static boolean contains3Type(String s){
        return containsUpperLetter(s) + containsLowerLetter(s) + containsDigit(s) + containsOther(s) >= 3;
    }
    //判断是否有相同长度大于2的子串重复,所以取长度为3的子串做比对
    public static boolean containsRepeat3(String s){
        for(int i=0;i<s.length()-2;i++){
            String sonString = s.substring(i,i+3);
            int count = 0;//子串的个数，如果>1,则不满足要求
            for(int j=0;j<s.length()-2;j++){
                if(s.charAt(j) == sonString.charAt(0) &&
                        s.charAt(j+1) == sonString.charAt(1) &&
                        s.charAt(j+2) == sonString.charAt(2)){
                    count++;
                }
            }
            if(count>1){
                return true;//
            }
        }
        return false;
    }
}
