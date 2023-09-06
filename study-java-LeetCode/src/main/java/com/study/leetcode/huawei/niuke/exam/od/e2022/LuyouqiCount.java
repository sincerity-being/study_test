package com.study.leetcode.huawei.niuke.exam.od.e2022;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-13 16:54
 * @describe
 * eg1: 输入:
 * news.qq.com
 * news.sina.com.cn
 * news.qq.com
 * news.qq.com
 * game.163.com
 * game.163.com
 * www.huawei.com
 * www.cctv.com
 * 3
 * www.huawei.com
 * www.cctv.com
 * www.huawei.com
 * www.cctv.com
 * www.huawei.com
 * www.cctv.com
 * www.huawei.com
 * www.cctv.com
 * www.huawei.com
 * 3
 *
 * 输入出:
 * news.qq.com,game.163.com,news.sina.com.cn
 * www.huawei.com,www.cctv.com,news.qq.com
 *
 *
 * eg2:
 * news.qq.com
 * www.cctv.com
 * 1
 * www.huawei.com
 * www.huawei.com
 * 2
 * 3
 *
 * 输出:
 * news.qq.com
 * www.huawei.com,news.qq.com
 * www.huawei.com,news.qq.com,www.cctv.com
 *
 */
public class LuyouqiCount {

     static Map<String, List<String>> recordsMap = new HashMap<>(16);
     static List<String> allRecordsList = new ArrayList<>(10);
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            List<String> recordsList = new ArrayList<>(10);
            int count = 0;
            while (in.hasNextLine()) {
                String first = in.nextLine();
                if (" ".equals(first)){
                 break;
                }
                if ( '0' <= first.charAt(0) && first.charAt(0) <= '9'){
                    List<String> allList = new ArrayList<>(16);
                    if (!allRecordsList.isEmpty()){
                        allList.addAll(allRecordsList);
                    }
                    allList.addAll(recordsList);
                   recordsMap.put(first + '-' + (count++),allList);
                   allRecordsList.addAll(recordsList);
                   recordsList = new ArrayList<>(10);
                }else {
                    recordsList.add(first);
                }
            }

            Map<String,List<String>> resultMap = new HashMap<>(16);
            // 进行 map处理
            for (String key : recordsMap.keySet()){
                List<String> list = recordsMap.get(key);
                Map<String,Integer> sortRecordsMap = new HashMap<>(16);
                for (String s : list){
                   if(sortRecordsMap.containsKey(s)){
                       sortRecordsMap.put(s,sortRecordsMap.get(s)+1);
                   }else{
                       sortRecordsMap.put(s,1);
                   }
                }
                // 分析 sortRecordMap
                List<String> keyList = new ArrayList<>(sortRecordsMap.keySet());
               String[] sortStrArray = new String[keyList.size()];
               String temp;
               for(int i = 0 ; i < keyList.size(); i++){
                      sortStrArray[i] = keyList.get(i);
               }


               // 进行排序
               for (int j = 0; j < sortStrArray.length-1; j++){
                   for (int k = 0; k < sortStrArray.length - 1-j ; k++){
                       if (sortRecordsMap.get(sortStrArray[k]) < sortRecordsMap.get(sortStrArray[k+1])){
                           temp = sortStrArray[k];
                           sortStrArray[k] = sortStrArray[k+1];
                           sortStrArray[k+1] = temp;
                       }else if (sortRecordsMap.get(sortStrArray[k]).equals(sortRecordsMap.get(sortStrArray[k+1]))){
                           if (sortStrArray[k].compareTo(sortStrArray[k+1]) > 0){
                               temp = sortStrArray[k];
                               sortStrArray[k] = sortStrArray[k+1];
                               sortStrArray[k+1] = temp;
                          }
                       }
                   }
               }

               String[] keyAllSplit = key.split("-");
               int number = Integer.parseInt(keyAllSplit[0]);
               List<String> resultList;
               if (number >= sortStrArray.length){
                   resultList = new ArrayList<>(Arrays.asList(sortStrArray));
               }else {
                   resultList = Arrays.stream(sortStrArray, 0, number).collect(Collectors.toList());
               }
               resultMap.put(key,resultList);
            }

            // 进行结果输出
            if (!resultMap.isEmpty()){
                for (String key : resultMap.keySet()){
                    System.out.println(resultMap.get(key));
                }
            }


        }

}
