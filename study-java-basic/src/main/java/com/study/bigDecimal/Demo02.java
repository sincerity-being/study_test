package com.study.bigDecimal;

import java.math.BigDecimal;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-01-25 15:04
 * @describe
 */
public class Demo02 {

    public static void main(String[] args) {

        Long a = 1000L;
        BigDecimal totalCount = new BigDecimal("1000");
        BigDecimal count = totalCount.subtract(new BigDecimal("100"));
        System.out.println("totalCount==" + totalCount.intValue());
        System.out.println(count);
    }
}
