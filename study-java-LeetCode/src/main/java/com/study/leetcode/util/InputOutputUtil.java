package com.study.leetcode.util;

import java.util.Scanner;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-17 20:47
 * @describe
 */
public class InputOutputUtil {

    public static String[] nextInStringArrayOut(){
        Scanner scanner = new Scanner(System.in);
        String  str  = scanner.next();
        String[]  testSplitStr = str.split("\\{}");
        if (testSplitStr.length == 0 || ("{").equals(testSplitStr[0])){
            return new String[0];
        }
        String[] splitStr = str.split(",");
        if (splitStr.length == 0){
            return new String[0];
        }
        if (splitStr[0].startsWith("{")){
            String[] temp = splitStr[0].split("\\{");
            splitStr[0] = temp[1];
        }
        if (splitStr[splitStr.length - 1].endsWith("}")){
            String[] temp = splitStr[splitStr.length-1].split("}");
            splitStr[splitStr.length-1] = temp[0];
        }
        return splitStr;
    }
}
