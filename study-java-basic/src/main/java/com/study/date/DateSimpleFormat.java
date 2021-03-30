package com.study.date;

import cn.hutool.core.date.DateUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-09-01 17:02
 *@describe:
 *@version:
 */
public class DateSimpleFormat {

    public static void main(String[] args) throws Exception{
       /* String dateStr = "2020-08-31 08:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = format.parse(dateStr);
        System.out.println("parse=="+parse);*/

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2020-08-31");
        System.out.println("date==" + date);

        System.out.println(format.format(DateUtil.tomorrow()));

        String t1 = "9:00";
        String  t2 = "10:00";
        String result = largerTime(t1,t2);
        System.out.println(result);
        System.out.println(DateUtil.parse("2020-10-21 17:00").getTime()/1000L);
        System.out.println(System.currentTimeMillis()/1000L);
    }

    private static String largerTime(String t1, String t2){
        Date date1, date2;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        try{
            date1 = format.parse(t1);
            date2 = format.parse(t2);
            if (date1.compareTo(date2) < 0){
                return  t2;
            }else{
                return  t1;
            }


        }catch(Exception e){


        }

        return  null;
    }


}
