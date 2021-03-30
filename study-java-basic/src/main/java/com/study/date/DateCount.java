package com.study.date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/***
 *
 *
 *@author : HeYQ
 *@date  2020-08-17 17:28
 *@describe :
 *@version :
 */
@Slf4j
public class DateCount {

    public static void main(String[] args) throws Exception {
        String dateStr = "2020-08-21 00:00:00";
        System.out.println(DateUtil.parse(dateStr));
        log.info("DateUtil.between(record.getPlanTime()," +
                "DateUtil.date(), DateUnit.DAY):{}",DateUtil.between(
                        DateUtil.parse(dateStr),
                DateUtil.date(), DateUnit.DAY));
        log.info("DateUtil.between(record.getPlanTime()," +
                "DateUtil.date(), DateUnit.HOUR):{}",DateUtil.between(
                        DateUtil.parse(dateStr),
                DateUtil.date(), DateUnit.HOUR));

        System.out.println( 1 /50);
        System.out.println(1 % 50);

        System.out.println((43200.0-40560.0)/3600);
        System.out.println("当天日期:" + DateUtil.beginOfDay(DateUtil.date()));
        System.out.println( DateUtil.offset(DateUtil.endOfDay(DateUtil.date()), DateField.DAY_OF_MONTH, 6));

        Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-08-21 00:00:00");
        System.out.println("date1==" + date1);
        String dateStr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date1);
        System.out.println(dateStr1);

        Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-11-28 10:51:35");
        Date date3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-12-01 00:00:00");
        System.out.println(DateUtil.between(date2,date3,DateUnit.HOUR));
        System.out.println(DateUtil.between(date2,date3,DateUnit.DAY));

        Date futurePlanTime = DateUtil.offsetDay(date2 != null
                ?date2:new Date(),365);

        System.out.println("futurePlanTime:{}"+ futurePlanTime);
        List<Integer> arr1 = Arrays.asList(1,2,3,4,5);
        List<Integer> arr2 = Arrays.asList(1,2,3,4,5);
        for (int i = 0 ; i < 5 ; i++){
            final int  a = arr1.get(i);
            Integer b = arr2.stream().filter( m -> m.equals(a)).findAny().orElse(null);
            if (!ObjectUtil.isEmpty(b)){
                System.out.println("b=====" + b);
            }
        }

    }

}
