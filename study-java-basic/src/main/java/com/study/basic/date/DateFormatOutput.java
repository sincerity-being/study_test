package com.study.basic.date;

import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-08-21 09:50
 *@describe:
 *@version:
 */
public class DateFormatOutput {

    public static void main(String[] args) throws Exception{
        System.out.println("DateUtil.date()===" + DateUtil.date());
        String formatDate = DateUtil.formatDate(DateUtil.date());
        System.out.println("formatDate==" + formatDate);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse( DateUtil.formatDate(DateUtil.date()));
        Date date2 = sdf.parse("2020-8-21");

        System.out.println(date1.compareTo(date2));
    }
}
