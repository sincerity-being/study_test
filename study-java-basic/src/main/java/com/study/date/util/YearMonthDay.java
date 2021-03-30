package com.study.date.util;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-14 18:06
 * @describe 通过类的方法来判断某年某月某日是当年的第几天。
 *
 *   分析:
 *   用OOP来封装一个类并通过该类的对象去解决当前的业务。
 *
 *   关键: 封装一个类。即: 从业务中将数据抽象出来，再将数据的处理方式方法抽象出来。
 *
 *    将它们构成一个整体就是一个类。
 *
 *   最后，实例化该类的对象，接着，调用对象的方法来解决当前的问题。
 */
public class YearMonthDay {

    private int year;

    private int month;

    private int day;

    static int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public YearMonthDay(){

    }

    public YearMonthDay(int y,int m,int d){
        this.year =y;
        this.month = m;
        this.day = d;
    }

    /** 设定器 */
    public void setYear(int year) {
        this.year = year;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setDay(int day) {
        this.day = day;
    }

    /** 访问器  */
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }


    /**
     * 方法 : 判断当年是否为闰年
     * 功能方法
     * @return
     */
    public boolean isNotLeapYear(){
        boolean isNotLeapYear = (year%4 == 0 && year%100 != 0) || year%400 == 0;
        if(isNotLeapYear ){
            return true;
        }else{
            return false;
        }
    }


    /**
     * 方法 : 根据是否闰年来确定二月份的天数
     */
    private void changeDaysOfTwoMonth(){
        if( isNotLeapYear() ){
            months[2] = 29;
        }else{
            months[2] = 28;
        }
    }

    /**
     * 方法: 统计当天是当年中的第几天
     * @return
     */
    public int totalDays(){
        //提前确定二月份的天数。
        changeDaysOfTwoMonth();
        int sum = 0;
        for(int m = 1; m < month;  m++ ){
            sum = sum + months[m];
        }
        sum = sum + day;
        return sum ;
    }

    public static void main(String[] args) {
        YearMonthDay  ymd = new YearMonthDay( 2012, 3, 1 );

        System.out.println("你给定的日期是: " + ymd.getYear() + "年" + ymd.getMonth()
                + "月" + ymd.getDay() + "日。");

        System.out.println("\n以上日期所在的年份是否为闰年？");

        boolean flag = ymd.isNotLeapYear();
        System.out.println("答案: " + (flag ? "闰年。" : "平年。" ));

        int days = ymd.totalDays();
        System.out.println("\n以上给定的日子在当年中是第 " + days + " 天。");
    }


}
