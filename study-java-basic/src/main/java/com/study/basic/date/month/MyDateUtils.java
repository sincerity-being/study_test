package com.study.basic.date.month;

import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-03 14:19
 * @describe
 */
public class MyDateUtils {

    /**
     * 获得当月1号零时零分零秒
     * @return
     */
    public static String initDateByMonth(Date date) throws  Exception{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
    }

    public static Date getFirstMonthDay1(Date date) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH,1);
        String first = format.format(c.getTime());
        System.out.println("===============first:"+first);
        return format.parse(first);
    }

    public static Date getLastMonthDay2(Date date) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
        System.out.println("===============last:"+last);
        System.out.println(ca.getTime());
        return format.parse(last);
    }


    public static Date getLastMonthDay1(Date date) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);
        Date d = ca.getTime();
        String last = format.format(d);
        System.out.println("===============last:"+last);
        System.out.println(d);
        return format.parse(last);
    }

    public static Date getFirstMonthDay(Date date){
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH,1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date getLastMonthDay(Date date) {
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);
        return ca.getTime();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(initDateByMonth(new Date()));
        Date month3 = DateUtil.offsetMonth(DateUtil.date(),3);
        System.out.println(month3);
        System.out.println(DateUtil.beginOfMonth(DateUtil.date()));

        Date firstMonthDay = getFirstMonthDay(new Date());
        System.out.println(firstMonthDay);

        Date lastMonthDay = getLastMonthDay2(new Date());
        System.out.println(lastMonthDay);


        Date lastMonthDay2 = getLastMonthDay(new Date());
        System.out.println(lastMonthDay2);

    }



}
