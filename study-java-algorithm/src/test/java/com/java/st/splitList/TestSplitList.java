package com.java.st.splitList;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-21 09:31
 *@describe:
 *@version:
 */
public class TestSplitList {


    @Test
    public void test(){
        List<Integer> numList = new ArrayList<>();
        numList.add(0,1);
        numList.add(0,2);
//[2, 1]
        System.out.println(numList);

    }



    @Test
    public void test2(){
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        numList.add(6);
        numList.add(7);
        numList.add(8);
        System.out.println(numList);
        //numList.remove(0);
        for (int i=0; i< 5 ; i++){
            numList.remove(0);
        }
        System.out.println(numList);


    }


    /**
     * gaibian
     * @param size
     * @param realSendMapList
     * @return
     */
    public  static List<Map<String,Object>> splitListMap(Integer size,
                                                      List<Map<String,Object>> realSendMapList){
        List<Map<String, Object>> targetSupList = realSendMapList.subList(0,size);
        for (int i=0; i< size ; i++){
            realSendMapList.remove(0);
        }

        return targetSupList;

    }



    /**
     * 注意： 改變了传进来的realSendList集合
     * @param size
     * @param realSendList
     * @return
     */
    public  static List<String> splitList(Integer size, List<String> realSendList){


        List<String> realTargetSupList = new ArrayList<>();
        List<String> targetSupList = realSendList.subList(0,size);
        realTargetSupList.addAll(targetSupList);

        for (int i=0; i< size ; i++){
            realSendList.remove(0);
        }


        return realTargetSupList;

    }

     //测试
    @Test
    public void testSplitList(){

        List<String> realSendList = new ArrayList<>();
        realSendList.add("1234");
        realSendList.add("5689");
        System.out.println("切割前:" + realSendList);

      /*  List<String> target = TestSplitList.splitList(1,realSendList);

        System.out.println("切割后:" + realSendList);
        System.out.println(target);*/

        for(int i = 0; i<2; i++){
            List<String> target = TestSplitList.splitList(1,realSendList);

            System.out.println("切割后:" + realSendList);
            System.out.println(target);

        }

       //一次循环
      /*  List<String> target = TestSplitList.splitList(1,realSendList);
        List<String> temporaryList = new ArrayList<>();
        temporaryList.addAll(realSendList);
        for (int i=0; i< 1 ; i++){
            temporaryList.remove(0);
        }
        System.out.println("切割后:" + temporaryList);
        System.out.println(target);*/







    }






}
