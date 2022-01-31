package com.study.basic.arithmetic.bigDecimal;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-29 13:45
 *@describe:
 *@version:
 */
@Slf4j
public class BigDecimalCount {


    public static void main(String[] args) {
        test1();
    }


    public  static void test1(){
        Long limitValue = new BigDecimal(1)
                .divide(new BigDecimal(1),4,
                        BigDecimal.ROUND_HALF_UP).longValue();

        log.info("limitValue===" + limitValue);
    }
}
