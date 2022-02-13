package com.study.algorithm.st.flow.flow2;

import java.util.*;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-16 15:29
 *@describe:
 *@version:
 */
public class MyFlowUtils {

    public static void main(String[] args) {
        List<Long> records = new ArrayList<>();
        records.add(120L);
        records.add(110L);
        records.add(100L);

        List<Integer> weightInfo = new ArrayList<>();
        weightInfo.add(50);
        weightInfo.add(40);
        weightInfo.add(10);




     /*   List<Long> recordsCopy = new ArrayList<>(records);

        System.out.println("recordsCopy===" + recordsCopy.hashCode());
        System.out.println("recordsCopy.toArray(new Long[recordsCopy.hashCode()])"
        + recordsCopy.toArray(new Long[recordsCopy.size()]).hashCode());
        //注意 recordsCopy 与 recordsCopy.toArray(new Long[recordsCopy.size()])
        //是两个不同的对象........
        insertSort(recordsCopy.toArray(new Long[recordsCopy.size()]));
        System.out.println("recordsCopy" + recordsCopy);*/

      /*  System.out.println("records===" + records);
        List<Long> arr =insertSortLong(records.toArray(new Long[records.size()]));
        System.out.println("records===" + records);
        System.out.println("arr===" + arr);

         /*输出结果:
            records===[120, 110, 100]
            records===[120, 110, 100]
            arr===[100, 110, 120]
        */

        /*List<long> recordsCopy = new ArrayList<>(records);
        insertSort(recordsCopy.toArray(new Long[recordsCopy.size()]));
        System.out.println("recordsCopy" + recordsCopy);*/


        Random random = new Random();

        long allNum = 0L;
       /* System.out.println("records===" + records.size());
        System.out.println("weightInfo====" + weightInfo.size());*/

     /*   int num = random.nextInt(100);
        List<Integer> res = doFlowUsingLeast(records,weightInfo,1);
        System.out.println(" flow==" + res);*/

     //模拟发送1000次,num总是100以内的数
      /*  for (int i = 0 ; i < 1000 ; i++){
            int num = random.nextInt(100);
            allNum += num;
            List<Integer> res = doFlowUsingLeast(records,weightInfo,1);

            System.out.println("num==" + num);
            System.out.println("flow==" + res);
            System.out.println("records==" + records);

            Long recodsNum = 0L;
            List<Double> vals = new ArrayList<>();
            for (Long longVal : records){
                recodsNum += longVal;
            }
            for (int j = 0 ; j < records.size(); j++){

                 double val = records.get(j)/(double)recodsNum;
                 vals.add(j,val);
            }

            System.out.println("vals==" + vals);

        }*/


        System.out.println("allNum==" + allNum);

        long allRecord = 0;
        for (int i = 0; i < records.size(); i++) {
            allRecord = allRecord + records.get(i);
        }
        System.out.println(allRecord);
    }

    /***
     *分流的方法.
     * @param records
     * @param weightInfo
     * @param num
     */
    public static List<Integer> doFlow(List<Long> records,List<Integer> weightInfo, int num){

        //结果返回list flow 分配方案
        List<Integer> res = new ArrayList<>();
        int  weightNum = 0;
        //先记录第一次分配的总数,而后记录是否有多余的那部分
        int count = 0;
        //第一次分配 按照用户输入的比重来分配..
        for(int i = 0 ; i < weightInfo.size(); i++){
          //  System.out.println("weightInfo.get(i)==" + weightInfo.get(i));
          // weightNum = (int)(num * (weightInfo.get(i) / 100.0)) ;
            //单次发送2000w以上可能会数据溢出
             weightNum = (num * weightInfo.get(i) ) / 100;
          // res.set(i, weightNum);
            res.add(i, weightNum);
           records.set(i,records.get(i) + weightNum);
           count += weightNum;
        }

        //进行多余的分配
        if(count != num){
            //map的key 是该渠道在redis记录的权重与用户输入的渠道权重的差值,
            // value records集合中对应的下标
            //反向排序,优先给一条给权重相差较大的渠道
            Map<String,Integer > compareMap = new  TreeMap<>(Collections.reverseOrder());

            long allNum = 0l;

            for (int j = 0 ; j < weightInfo.size(); j++){
                allNum += records.get(j);
            }

            for(int i = 0 ; i < weightInfo.size(); i++){
              double val = records.get(i) /(double)allNum - weightInfo.get(i)/100.0;
               compareMap.put(val+"" + i, i);
            }
            count = num-count;

         inner: while(count > 0){
             for (String key : compareMap.keySet()){
                // System.out.println(" key===" + key);
                  if (count > 0) {
                      res.set(compareMap.get(key),res.get(compareMap.get(key)) + 1);
                      records.set(compareMap.get(key),records.get(compareMap.get(key))+1);
                      count--;
                  }else{
                      break inner;
                  }
              }
          }

        }
        return res;
    }



    /***
     *分流的方法.
     * @param records
     * @param weightInfo
     * @param num
     */
    public static List<Integer> doFlowUsingLeast(List<Long> records,
                                                 List<Integer> weightInfo, int num){

        //结果返回list flow 分配方案
        List<Integer> res = new ArrayList<>();
        int  weightNum = 0;
        //先记录第一次分配的总数,而后记录是否有多余的那部分
        int count = 0;
        //第一次分配 按照用户输入的比重来分配..
        for(int i = 0 ; i < weightInfo.size(); i++){
            //  System.out.println("weightInfo.get(i)==" + weightInfo.get(i));
            // weightNum = (int)(num * (weightInfo.get(i) / 100.0)) ;
            //单次发送2000w以上可能会数据溢出
            weightNum = (num * weightInfo.get(i) ) / 100;
            // res.set(i, weightNum);
            res.add(i, weightNum);
            records.set(i,records.get(i) + weightNum);
            count += weightNum;
        }

        //进行多余的分配
        if(count != num){

            long allNum = 0l;

            for (int j = 0 ; j < weightInfo.size(); j++){
                allNum += records.get(j);
            }

            //很重要的一环
            count = num-count;
            //从小到大排序
            inner: while(count > 0){


                    if (count > 0) {
                        List<Long> recordsCopy=insertSortLong(records.toArray(
                                new Long[records.size()]));
                        for (int k = 0; k < records.size(); k++){
                            if(recordsCopy.get(0).longValue() == records.get(k)){
                                records.set(k,records.get(k)+1);
                                res.set(k,res.get(k)+1);
                                count--;
                                break;
                            }
                        }

                    }else{
                        break inner;
                    }
            }

        }
        return res;
    }


    //写个排序算法 使用插入排序
    public static void insertSort(Long[] arr){
        Long insertVal = 0L;
        int insertIndex = 0;
        System.out.println("arr====改变前" + arr);
        //使用for循环来把代码进行简化
        for (int i = 1; i < arr.length; i++) {
            // 定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标
            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            // 这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }

        System.out.println("arr==改變后" + arr);
    }


    //写个排序算法 使用插入排序
    public static List<Long> insertSortLong(Long[] arr){

        long insertVal = 0L;
        int insertIndex = 0;
        //使用for循环来把代码进行简化
        for (int i = 1; i < arr.length; i++) {
            // 定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标
            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            // 这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }

        return  Arrays.asList(arr);
    }

    //写个排序算法 使用插入排序
   /* public static void insertSort(long[] arr){
       long insertVal = 0L;
        int insertIndex = 0;
        //使用for循环来把代码进行简化
        for (int i = 1; i < arr.length; i++) {
            // 定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标
            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            // 这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }*/



}
