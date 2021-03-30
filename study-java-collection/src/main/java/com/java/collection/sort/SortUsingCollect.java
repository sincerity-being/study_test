package com.java.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 *
 *
 *@ author: HeYQ
 *@ date: 2020-09-03 16:50
 *@ describe:
 *@ version:
 */
public class SortUsingCollect {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("3");
        list1.add("4");
        list1.add("1");
        list1.add("2");
        System.out.println("排序前--:"+list1.toString());
       // Collections.sort(list1);
        List<String> list2 =  new ArrayList<>();
        list2.addAll(list1);
        System.out.println("排序前--:"+list2.toString());
        Collections.sort(list2);
        System.out.println("排序前后--:"+list1.toString());

        System.out.println("排序前后--:"+list2.toString());


    }


}
