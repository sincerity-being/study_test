package com.study.date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-09-06 19:19
 *@describe:
 *@version:
 */
public class SplitDateTimeUtil {



    public static void main(String[] args) throws Exception {

      /*  String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);

        Date beginOfDay = DateUtil.beginOfDay(date);

        Date endOfDay = DateUtil.endOfDay(date);

        System.out.println( endOfDay);
        Date newDate = DateUtil.offset(endOfDay, DateField.MILLISECOND, 1);
        System.out.println(newDate);*/


      // String dateStr1 = "2020-09-02 23:56:23";
       // String dateStr1 = "2020-09-02 10:56:23";
        //String dateStr1 = "2020-09-02 23:56:23";
        String  dateStr1 ="2020-09-07 11:58:00";
        Date date1 = DateUtil.parse(dateStr1);

     //  String dateStr2 = "2020-09-05 01:00:00";
       // String dateStr2 = "2020-09-03 23:00:00";
        //String dateStr2 = "2020-09-04 23:00:00";
        String dateStr2 = "2020-09-08 11:58:00";
        Date date2 = DateUtil.parse(dateStr2);

//相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        long minute = DateUtil.between(date1, date2, DateUnit.HOUR);
        System.out.println(betweenDay);
        System.out.println(minute);



        List<PeriodTimeSectionBo> list = splitDateTime(date1,date2);
       List<Date>  endTimes = list.stream()
               .map(p -> p.getPeriodEndTime()).collect(Collectors.toList());
      for (PeriodTimeSectionBo periodTimeSectionBo : list){
          System.out.println(periodTimeSectionBo.getPeriodStartTime());
          System.out.println(periodTimeSectionBo.getPeriodEndTime());
          System.out.println(periodTimeSectionBo.getSecondsInterval());
      }
       for (Date date : endTimes){
           System.out.println("date ===" + date);
       }
        //方法 一
        long time1 = System.currentTimeMillis();
//方法 二
        long time2 = Calendar.getInstance().getTimeInMillis();
//方法 三
        long time3 = new Date().getTime();


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        System.out.println("当前时间："+date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time= simpleDateFormat.parse(date);

        long timeStamp= time.getTime();
        System.out.println(timeStamp);

//s是String类型的时间戳
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timeStamp1= new Long(1599458782000L);
        Date date8= new Date(timeStamp1);
        String time8= simpleDateFormat1.format(date8);
        System.out.println(time8);




    }


    public static List<PeriodTimeSectionBo> splitDateTime(Date periodStart, Date periodEnd) {
        long days = DateUtil.between(periodStart, periodEnd, DateUnit.DAY) + 1;
        List<PeriodTimeSectionBo> sectionBoList = new ArrayList<>();
        for (int i = 1; i <= days; i++){
            PeriodTimeSectionBo sectionBo = new PeriodTimeSectionBo();
            Date newStartOneDay = null;
            Date endOfOneDay = null ;
            if(days == 1) {
                newStartOneDay = periodStart;
                endOfOneDay = DateUtil.endOfDay(periodStart);
                if (periodEnd.compareTo(DateUtil.offset(endOfOneDay, DateField.SECOND, 1)) <= 0){
                    sectionBo.setPeriodStartTime(newStartOneDay);
                    sectionBo.setPeriodEndTime(periodEnd);
                    sectionBo.setSecondsInterval(DateUtil
                            .between(sectionBo.getPeriodStartTime(),sectionBo.getPeriodEndTime(),DateUnit.SECOND));
                    sectionBoList.add(sectionBo);
                    break;
                }
                sectionBo.setPeriodStartTime(newStartOneDay);
                sectionBo.setPeriodEndTime(endOfOneDay);
                sectionBo.setSecondsInterval(DateUtil
                        .between(sectionBo.getPeriodStartTime(),sectionBo.getPeriodEndTime(),DateUnit.SECOND) + 1);
                sectionBoList.add(sectionBo);
                PeriodTimeSectionBo sectionBo2 = new PeriodTimeSectionBo();
                sectionBo2.setPeriodStartTime(DateUtil.offset(endOfOneDay, DateField.SECOND, 1));
                sectionBo2.setPeriodEndTime(periodEnd);
                sectionBo2.setSecondsInterval(DateUtil
                        .between(sectionBo2.getPeriodStartTime(),sectionBo2.getPeriodEndTime(),DateUnit.SECOND));
                sectionBoList.add(sectionBo2);
                break;
            }
            if (i == 1){
                sectionBo.setPeriodStartTime(periodStart);
                sectionBo.setPeriodEndTime(DateUtil.endOfDay(periodStart));
                sectionBo.setSecondsInterval(DateUtil
                        .between(sectionBo.getPeriodStartTime(),sectionBo.getPeriodEndTime(),DateUnit.SECOND));
                sectionBoList.add(sectionBo);
                continue;
            }
            if (i > 1 && i < days){
                sectionBo.setPeriodStartTime(DateUtil.offset(sectionBoList.get(i-2).getPeriodEndTime(),
                        DateField.SECOND, 1));
                sectionBo.setPeriodEndTime(DateUtil.endOfDay(sectionBo.getPeriodStartTime()));
                sectionBo.setSecondsInterval(DateUtil
                        .between(sectionBo.getPeriodStartTime(),sectionBo.getPeriodEndTime(),DateUnit.SECOND)+ 1);
                sectionBoList.add(sectionBo);
            }
            if (i==days){
                newStartOneDay = DateUtil.offset(sectionBoList.get(i-2).getPeriodEndTime(),
                        DateField.SECOND, 1);
                endOfOneDay = DateUtil.endOfDay(newStartOneDay);
                if (periodEnd.compareTo(DateUtil.offset(endOfOneDay, DateField.SECOND, 1))<= 0){
                    sectionBo.setPeriodStartTime(newStartOneDay);
                    sectionBo.setPeriodEndTime(periodEnd);
                    sectionBo.setSecondsInterval(DateUtil
                            .between(sectionBo.getPeriodStartTime(),sectionBo.getPeriodEndTime(),DateUnit.SECOND));
                    sectionBoList.add(sectionBo);
                    break;
                }
                sectionBo.setPeriodStartTime(newStartOneDay);
                sectionBo.setPeriodEndTime(endOfOneDay);
                sectionBo.setSecondsInterval(DateUtil
                        .between(sectionBo.getPeriodStartTime(),sectionBo.getPeriodEndTime(),DateUnit.SECOND) + 1);
                sectionBoList.add(sectionBo);
                PeriodTimeSectionBo sectionBo2 = new PeriodTimeSectionBo();
                sectionBo2.setPeriodStartTime(DateUtil.offset(endOfOneDay, DateField.SECOND, 1));
                sectionBo2.setPeriodEndTime(periodEnd);
                sectionBo2.setSecondsInterval(DateUtil
                        .between(sectionBo2.getPeriodStartTime(),sectionBo2.getPeriodEndTime(),DateUnit.SECOND));
                sectionBoList.add(sectionBo2);
                break;
            }
        }
        return  sectionBoList;
    }
}
