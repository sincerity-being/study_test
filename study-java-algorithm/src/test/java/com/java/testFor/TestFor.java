package com.java.testFor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-21 13:55
 *@describe:
 *@version:
 */
public class TestFor {

    @Test
       public  void test(){
            for (int i =0 ; i<2; i++){
                Student student = new Student();
                System.out.println(student.hashCode());
            }
       }

       @Test
       public void testListToArray(){
           List<String> mlist = new ArrayList<>();
           mlist.add("zhu");
           mlist.add("wen");
           mlist.add("tao");
           // List转成数组
           String[] array = mlist.toArray(new String[0]);
           // 输出数组
           for (int i = 0; i < array.length; i++) {
               System.out.println("array--> " + array[i]);
           }
       }

}
