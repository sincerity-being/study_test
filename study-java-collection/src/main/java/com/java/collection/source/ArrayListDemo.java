package com.java.collection.source;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-12-14 10:56
 * @describe
 */
public class ArrayListDemo {

    public static void main(String[] args) throws ParseException {
        System.out.println(10 >> 1);
        System.out.println(10 << 1);

        List<Integer> removeMaintainPlanDeviceIds = new ArrayList<>();
       /* removeMaintainPlanDeviceIds.add(161);
        removeMaintainPlanDeviceIds.add(162);
        removeMaintainPlanDeviceIds.add(163);*/
        List<Integer> maintainPlanSimpleBoIds = new ArrayList<>();
        maintainPlanSimpleBoIds.add(165);
        maintainPlanSimpleBoIds.add(166);
        maintainPlanSimpleBoIds.add(167);
        removeMaintainPlanDeviceIds.removeAll( maintainPlanSimpleBoIds);
        System.out.println( removeMaintainPlanDeviceIds);
        System.out.println(maintainPlanSimpleBoIds);
     //   System.out.println(list1.removeAll(list2));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2020-12-14 02:12:11");
        Date date2 = sdf.parse("2020-12-14");
        System.out.println(date1.compareTo(date2) != 0);
    }
}
