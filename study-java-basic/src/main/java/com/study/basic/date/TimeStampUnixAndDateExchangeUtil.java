package com.study.basic.date;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/***
 *
 *@ author: HeYQ
 *@ date: 2020-10-22 10:05
 *@ version: 1.0
 *@ describe: unix时间戳与指定格式日期的相互转换.
 *
 */
public class TimeStampUnixAndDateExchangeUtil {

    /**
    *Java将Unix时间戳转换成指定格式日期
    *@ author: HeYQ
    *@ date: 2020/10/22 10:09
    *@ param timeStampString 时间戳字符串
    *@ param  formats 指定格式
    *@ return
    *@ vision: 1.0
    */
    public static Date TimeStamp2Date(String timeStampString, String formats){
        if (ObjectUtil.isEmpty(formats)){
            formats = "yyyy-MM-dd HH:mm:ss";
        }
        Long timeStamp = Long.parseLong(timeStampString) * 1000;
        String dateString = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timeStamp));
        return DateUtil.parse(dateString);
    }
    /**
    *日期格式字符串转换成时间戳
    *@ author: HeYQ
    *@ date: 2020/10/22 10:13
    *@ param  dateStr 字符串日期
    *@ param  format   如：yyyy-MM-dd HH:mm:ss
    *@ return
    *@ vision:
    */
    public static String Date2TimeStamp(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(dateStr).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(TimeStamp2Date("1473048265", "yyyy-MM-dd HH:mm:ss"));
        System.out.println(Date2TimeStamp("2016-09-05 12:04:25","yyyy-MM-dd HH:mm:ss"));
        System.out.println("============================================================================");
        System.out.println("newDate="+TimeStamp2Date("1603382400", "yyyy-MM-dd HH:mm:ss"));
        System.out.println("newDate="+TimeStamp2Date("1603771200", "yyyy-MM-dd HH:mm:ss"));

        System.out.println(TimeStamp2Date("1603814400", "yyyy-MM-dd HH:mm:ss"));
        System.out.println(28800.0/3600);
        System.out.println(43200.0/3600);

        System.out.println(46800.0/3600);
        System.out.println(61200.0/3600);

        System.out.println(86400.0/3600);
        System.out.println("user_begin_time="+TimeStamp2Date("1603382400", "yyyy-MM-dd HH:mm:ss"));
        System.out.println("user_end_time="+TimeStamp2Date("1603771200", "yyyy-MM-dd HH:mm:ss"));

        System.out.println(259200.0/3600/24);
        System.out.println(259200.0/3600/8);
        System.out.println(69120.0/3600);


        System.out.println(86400.0/3600);
        System.out.println(new BigDecimal(86400).divide(new BigDecimal(3600.0),1,BigDecimal.ROUND_UP));
        System.out.println("============================================================================");
        System.out.println(Date2TimeStamp("2020-10-21 14:30:25","yyyy-MM-dd HH:mm:ss"));
        System.out.println(System.currentTimeMillis()/1000L);


    }


}
