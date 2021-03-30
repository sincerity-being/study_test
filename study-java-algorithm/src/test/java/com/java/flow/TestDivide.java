package com.java.flow;

import org.junit.Test;

import java.math.BigDecimal;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-16 18:19
 *@describe:
 *@version:
 */
public class TestDivide {

    public static void main(String[] args) {
        int  weightNum = (int)(59 * (50 / 100.0));
        System.out.println("weightNum====" + weightNum);

        double val1 =  100L/(double )200L;
        System.out.println("val1===" + val1);
        double val = 100L/(double)200L- 50/100.0;
        System.out.println("val====" + val);
    }

    @Test
    public void test(){

    }

}
