package com.study.basic.date;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-08-31 09:16
 *@describe:
 *@version:
 */
public class CountHourByCount {


    public static void main(String[] args) throws Exception {
        String dateStr1 = "2020-09-14 00:00:01";
        Date date1 = DateUtil.parse(dateStr1);

       // String dateStr2 = "2020-09-13 23:54:45";
        String dateStr2 = "2020-09-14 00:00:00";
        Date date2 = DateUtil.parse(dateStr2);

//相差一个月，31天
        //long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        System.out.println("betweenDay:{}" + betweenDay);

        String s = "12.199";
        if(s.matches("[^\\.]*\\.[^\\.]*")){
            System.out.println(s + "只有一个小数点");
        }else{
            System.out.println(s + " 有多个小数点");
        }


       /* Long total = Long.parseLong(1.2 * 3600 + "");
        System.out.println(" total" +total);*/


            double d = 88.88;
            long l = Math.round(d);
            System.out.println(l);

            long ll = 100L;
            double dd = (double) ll;
            System.out.println(dd);

        Date startTime =  covertTime(new Date());
        Date endTime =  DateUtil.offsetSecond(startTime,1080000);

        System.out.println("startTime" + startTime);
        System.out.println("endTime" + endTime);

    }

    public static Date covertTime(Date date)throws Exception  {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp now = new Timestamp(date.getTime());
        String str = df.format(now);
        Date newDate = null;
        try {
            newDate = df.parse(str);
        } catch (ParseException e) {

        }
        return newDate;
    }

}
