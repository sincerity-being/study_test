package com.study.date.month;

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

    public static void main(String[] args) throws Exception {
        System.out.println(initDateByMonth(new Date()));
        Date month3 = DateUtil.offsetMonth(DateUtil.date(),3);
        System.out.println(month3);
        System.out.println(DateUtil.beginOfMonth(DateUtil.date()));
    }
}
