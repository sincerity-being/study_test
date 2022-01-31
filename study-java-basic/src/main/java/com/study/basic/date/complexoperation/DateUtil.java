package com.study.basic.date.complexoperation;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: HeYQ
 * @date: 2020-10-29 09:16
 * @version: 1.0
 * @describe:java 日期获取，每月一号，每周一
 * https://www.cnblogs.com/mayhh/p/11354818.html
 */
public class DateUtil {


    /**
     * 增加天数
     *
     * @param sdf
     */
    public static void addDay(SimpleDateFormat sdf, int days) {

        //获取Calendar实例，java封装的表现，
        // private类Calendar的构造函数，通过静态方法创建对象
        Calendar calendar = Calendar.getInstance();
        //获取当前时间并格式化
        System.out.println("当前时间: " + sdf.format(calendar.getTime()));
        //给当前时间加上天数days并输出，这里的第一个参数用以下三个都可以
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DAY_OF_YEAR, days);
        System.out.println("加了" + days + "天之后的时间: " + sdf.format(calendar1.getTime()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DAY_OF_MONTH, days);
        System.out.println("加了" + days + "之后的时间: " + sdf.format(calendar2.getTime()));
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(Calendar.DAY_OF_WEEK, days);
        System.out.println("加了" + days + "之后的时间: " + sdf.format(calendar3.getTime()));
    }

    /**
     * 获取当前星期、前一星期、后一星期的第一天和最后一天
     *
     * @param sdf
     */
    public static void getWeekDay(SimpleDateFormat sdf) {

        //获取Calendar实例，java封装的表现，private类Calendar的构造函数，
        // 通过静态方法创建对象
        Calendar calendar = Calendar.getInstance();
        //获取当前时间并格式化
        System.out.println("当前时间: " + sdf.format(calendar.getTime()));
        //本周一
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println("本周一: " + sdf.format(calendar1.getTime()));
        //本周日
        Calendar calendar2 = Calendar.getInstance();
        //外国的星期天和我们的不在一周(外国是星期天到星期六为一个星期)
        calendar2.add(Calendar.DAY_OF_WEEK, 7);
        calendar2.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        System.out.println("本周日: " + sdf.format(calendar2.getTime()));
        //下周一
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(Calendar.DAY_OF_MONTH, 7);
        calendar3.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println("下周一: " + sdf.format(calendar3.getTime()));
        //下周日
        Calendar calendar4 = Calendar.getInstance();
        calendar4.add(Calendar.DAY_OF_MONTH, 14);
        calendar4.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        System.out.println("下周日: " + sdf.format(calendar4.getTime()));
        //上周一
        Calendar calendar5 = Calendar.getInstance();
        calendar5.add(Calendar.DAY_OF_YEAR, -7);
        calendar5.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println("上周一: " + sdf.format(calendar5.getTime()));

        //上周日
        Calendar calendar6 = Calendar.getInstance();
        calendar6.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        System.out.println("上周日: " + sdf.format(calendar6.getTime()));

    }

    /**
     * 获取当前月、前一月、后一月的第一天和最后一天
     * @param sdf
     */
    public static void getMonth(SimpleDateFormat sdf){
        //定义当前月的总天数，比如30,31,28,29
        int maxCurrentMonthDay=0;
        Calendar calendar=Calendar.getInstance();
        System.out.println("当前时间: "+sdf.format(calendar.getTime()));

        //当月一号
        Calendar calendar1=Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("本月第一天: "+sdf.format(calendar1.getTime()));

        //当月最后一天
        Calendar calendar2=Calendar.getInstance();
        maxCurrentMonthDay=calendar2.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar2.set(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);
        System.out.println("本月最后一天: "+sdf.format(calendar2.getTime()));

        //下个月一号
        Calendar calendar3=Calendar.getInstance();
        maxCurrentMonthDay=calendar3.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar3.add(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);
        calendar3.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("下月第一天: "+sdf.format(calendar3.getTime()));

        //下个月最后一天
        Calendar calendar4=Calendar.getInstance();
        maxCurrentMonthDay=calendar4.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar4.add(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);

        //第一个maxCurrentMonthDay获取的是当月的天数，第二个maxCurrentMonthDay获取的是下个月的天数
        maxCurrentMonthDay=calendar4.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar4.set(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);
        System.out.println("下月第一天: "+sdf.format(calendar4.getTime()));

        //上个月一号
        Calendar calendar5=Calendar.getInstance();
        maxCurrentMonthDay=calendar5.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar5.add(Calendar.DAY_OF_MONTH, -maxCurrentMonthDay);
        calendar5.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("上月第一天: "+sdf.format(calendar5.getTime()));

        //上个月最后一天
        Calendar calendar6=Calendar.getInstance();
        maxCurrentMonthDay=calendar6.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar6.add(Calendar.DAY_OF_MONTH, -maxCurrentMonthDay);

        //第一个maxCurrentMonthDay获取的是当月的天数，
        // 第二个maxCurrentMonthDay获取的是上个月的天数
        maxCurrentMonthDay=calendar6.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar6.set(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);
        System.out.println("上月第一天: "+sdf.format(calendar6.getTime()));
    }

    public static void main(String[] args) {

       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date yesterday =  DateUtils.addDays(cn.hutool.core.date.DateUtil.date(),-1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(yesterday);
        String str = sdf.format(calendar.getTime());
        System.out.println(str);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("本月第一天: "+sdf.format(calendar.getTime()));
    }

}
