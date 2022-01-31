package com.study.basic.easyCoding.chapter06.list;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import java.util.ArrayList;
import java.util.List;

/**
 * 注释..
 * <p>  </p>
 *
 * @author 何裕墙  heyuqiang@kungeek.com
 * @since 1.0
 */
public class ListNoGeneric {

    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new Integer(111));
        a1.add(new String("hello a1a1"));

        List<Object> a2 = a1;
        a2.add(new Object());
        a2.add(new Integer(222));
        a2.add(new String("hello a2a2"));


        List<Integer> a3 = a1;
        a3.add(new Integer(333));

       // a3.add(new Object());
       // a3.add(new String("hello a2a2"));
        // a2 = a3;
        a1 = a3;

        List<?> a4 = a1;
        a4.remove(0);
        a4.clear();

      //  a4.add(new Object());

//      List<?> a5 = new ArrayList<>();
//      a5.add(new Object());

    }

}
