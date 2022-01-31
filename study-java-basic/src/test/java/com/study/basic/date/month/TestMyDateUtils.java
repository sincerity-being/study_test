package com.study.basic.date.month;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import org.junit.Test;

import java.util.Date;

/**
 * <pre>
 *
 * </pre>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
public class TestMyDateUtils {

    @Test
    public void test(){
        System.out.println(MyDateUtils.getFirstMonthDay(new Date()));
        System.out.println(MyDateUtils.getLastMonthDay(new Date()));
    }
}
