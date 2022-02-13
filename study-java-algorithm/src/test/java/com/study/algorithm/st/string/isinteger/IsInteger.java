package com.study.algorithm.st.string.isinteger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-16 21:25
 *@describe:
 *@version:
 */
public class IsInteger {


    public static void main(String[] args) {
        System.out.println(strIsInteger("123.12"));
        System.out.println(strIsInteger("123"));
        System.out.println(strIsInteger("-1"));
        System.out.println(strIsInteger0100("123.12"));
        System.out.println(strIsInteger0100("123"));
        System.out.println(strIsInteger0100("-1"));
        System.out.println(strIsInteger0100("100"));
        System.out.println(strIsInteger0100("0"));
        System.out.println(strIsInteger0100("99"));
    }

    /***
     *
     * @param str
     * @return
     */
    public static boolean strIsInteger(String str){

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher((CharSequence) str);
        boolean result = matcher.matches();
      /*  if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }*/

        return result;
    }

    public static boolean strIsInteger0100(String str){

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher((CharSequence) str);
        boolean result = matcher.matches();
        if(result){
            Integer strInteger = Integer.parseInt(str);
             if(0 > strInteger || strInteger > 100){
                  result = false;
             }
        }
        return result;
    }

}
