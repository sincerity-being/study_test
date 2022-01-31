package com.study.basic.date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-08-12 09:18
 *@describe:
 *@version:
 */
public class DateMigration {

    public static void main(String[] args) {


        Date date = DateUtil.date();
        Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH,-31);

       // String format = DateUtil.format(newDate,"yyyy-MM-dd");
        String format = DateUtil.formatDate(newDate);
        System.out.println("format===" + format);
        System.out.println(newDate);

        DateTime time = new DateTime(date);
        System.out.println(time);

        System.out.println("newDate===" + DateUtil.parse(format));
    }
}
