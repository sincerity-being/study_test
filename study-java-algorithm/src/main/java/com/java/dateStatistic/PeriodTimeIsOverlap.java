package com.java.dateStatistic;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-09-03 09:04
 *@describe:
 *@version:
 */
public class PeriodTimeIsOverlap {

    public static void main(String[] args) {
        try {
            boolean b = isOverlap();
            System.out.println("是否重复(true:重复，false:不重复)："+b);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public static boolean isOverlap() throws ParseException {
        //造3个时间段数据
        List<Timestamp> periodStart = new ArrayList<Timestamp>();
        List<Timestamp> periodEnd = new ArrayList<Timestamp>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //第一个时间段
       Date start1 = sdf.parse("2020-1-6 00:00:00");
        Date end1 = sdf.parse("2020-1-11 00:00:00");
        //第二个时间段
        Date start2 = sdf.parse("2020-1-4 00:00:00");
        Date end2 = sdf.parse("2020-1-7 00:00:00");
        //第三个时间段
        Date start3 = sdf.parse("2020-1-4 00:00:00");
        Date end3 = sdf.parse("2020-1-5 00:00:00");

        //开始时间放到一个数组
       // periodStart.add(new Timestamp(start1.getTime()));
        periodStart.add(new Timestamp(start2.getTime()));
        periodStart.add(new Timestamp(start3.getTime()));
        //结束时间放到一个数组
       // periodEnd.add(new Timestamp(end1.getTime()));
        periodEnd.add(new Timestamp(end2.getTime()));
        periodEnd.add(new Timestamp(end3.getTime()));
        /**
         * 两两循环比较
         * 这里的3代表有三组数据，先写死
         */
       // System.out.println("new Timestamp(start1.getTime())==" + new Timestamp(start1.getTime()));
        for (int i = 0; i < periodStart.size()-1; i++) {
            Timestamp start0 = periodStart.get(i);
            Timestamp end0 = periodEnd.get(i);
            for (int j = i+1; j < periodStart.size(); j++) {
                Timestamp start = periodStart.get(j);
                Timestamp end = periodEnd.get(j);
                if(start0.compareTo(end)>=0 || end0.compareTo(start)<=0){
                    /**
                     * 说明不重复。
                     * 思路：该时间段的开始时间如何大于另个一个时间段的结束时间，那么这个两个时间段不会有重叠；
                     * 如果该时间段的结束时间小于另一个时间段的时间，那么这个两个时间段也不会有重叠。
                     */
                    continue;
                }else{
                    //说明该时间段重复
                    return true;
                }
            }
        }
        return false;
    }


}
