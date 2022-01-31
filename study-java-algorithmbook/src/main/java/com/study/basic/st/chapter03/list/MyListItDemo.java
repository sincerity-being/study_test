package com.study.basic.st.chapter03.list;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
public class MyListItDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        list.add(1);
        Iterator<Integer> iterable = list.iterator();
        while (iterable.hasNext()) {
            System.out.println(iterable.next());
        }
    }

}
