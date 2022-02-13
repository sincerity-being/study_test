package com.study.algorithm.st.faben.string;
import java.util.Scanner;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-02-08 10:56
 * @describe
 */
public class PressStringDemo {

    public static  String comPressStr(String srcStr){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < srcStr.length(); i++){
            int count = 1;
            // 体现连续的思想
            for(int j = i + 1 ; j < srcStr.length(); j++){
                if (srcStr.charAt(i) == srcStr.charAt(j)){
                   count++;
                }else{
                    break;
                }
            }
            if (count >= 2){
                sb.append(srcStr.charAt(i)).append(count);
                // 关键移动坐标.
                i = i + count -1;
            }else{
                sb.append(srcStr.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       // ababababab ttabababatttt abttabttttccaabb
        String srcStr = scanner.next();
        System.out.println("srcStr==" +srcStr);
        System.out.println(srcStr.substring(1));
        System.out.println(srcStr.substring(2));
        String destStr = comPressStr(srcStr);
        System.out.println("destStr==" + destStr);
    }
}
