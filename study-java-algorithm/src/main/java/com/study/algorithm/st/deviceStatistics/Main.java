package com.study.algorithm.st.deviceStatistics;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        long h = 3600000;
        String date = "2020-08-20 10:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = format.parse(date);

        DeviceStatistic statistic = new DeviceStatistic();
        statistic.addInterval(1, parse.getTime(), parse.getTime() + 20 * h);
        System.out.println(statistic.useList);
        statistic.addInterval(1, parse.getTime() + 10 * h, parse.getTime() + 20 * h);
        System.out.println(statistic.useList);
        statistic.addInterval(1, parse.getTime() + 21 * h, parse.getTime() + 30 * h);
        System.out.println(statistic.useList);
        statistic.addInterval(1, parse.getTime() + 31 * h, parse.getTime() + 50 * h);
        System.out.println(statistic.useList);
        statistic.addInterval(1, parse.getTime() + 10 * h, parse.getTime() + 100 * h);
        System.out.println(statistic.useList);
        boolean malFlag = statistic.addInterval(2, parse.getTime(), parse.getTime() + h);
        System.out.println(malFlag);

        boolean otherFlag = statistic.addInterval(3, parse.getTime() + h, parse.getTime() + 20 * h);
        System.out.println(otherFlag);

        String[] splitStr =    "1.1".split("\\.");
        System.out.println(splitStr[0]);
        System.out.println(statistic.getRate(parse.getTime(), parse.getTime() + 100 * h));

    }
}
