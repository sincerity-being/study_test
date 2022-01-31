package com.study.basic.operator;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


/**
 * 注释..
 * <p>  </p>
 *
 * @author 何裕墙  heyuqiang@kungeek.com
 * @since 1.0
 */
public class URShift {

    public static void main(String[] args) {
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
        byte b = -1;
        System.out.println("b" + Integer.toBinaryString(b));
        b >>>=4;
        System.out.println("b" + Integer.toBinaryString(b));
        System.out.println("b" + Integer.toBinaryString(b>>>10));
    }
}
