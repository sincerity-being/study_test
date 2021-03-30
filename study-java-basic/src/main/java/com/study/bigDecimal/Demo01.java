package com.study.bigDecimal;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-09-04 14:20
 *@describe:
 *@version:
 */
public class Demo01 {

    public static void main(String[] args) {
         double d = BigDecimal.valueOf(130).
                 divide(BigDecimal.valueOf(60),1,
                         BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("d ===" + d);

        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);

        System.out.println("date2.getTime()==" + date2.getTime());
//相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);

        System.out.println("betweenDay==" + betweenDay);

        double a = 0.0001d;
        long f = (long) (a * 10000);
        System.out.println(a * 10000);
        System.out.println(f);
        System.out.println((double)f/10000);

        List<Integer> ab = new ArrayList<>(Arrays.asList(1,2,3,4));
        ab.remove(Integer.valueOf(1));
        System.out.println(ab);
    }
}
