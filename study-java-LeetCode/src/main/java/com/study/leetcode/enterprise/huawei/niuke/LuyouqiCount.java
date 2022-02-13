package com.study.leetcode.enterprise.huawei.niuke;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-13 16:54
 * @describe
 */
public class LuyouqiCount {

     static Map<String, List<String>> recordsMap = new HashMap<>(16);
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            List<String> recordsList = new ArrayList<>(10);
            int count = 0;
            while (in.hasNextLine()) {
                String first = in.nextLine();
                if (" ".equals(first)){
                 break;
                }
                char c = first.charAt(0);
                if ( '0' <= first.charAt(0) && first.charAt(0) <= '9'){
                    List<String> allList = new ArrayList<>(16);
                    if (!recordsMap.isEmpty()){
                        for (String allKey : recordsMap.keySet()){
                            allList.addAll(recordsMap.get(allKey));
                        }
                    }
                    allList.addAll(recordsList);
                   recordsMap.put(first + '-' + (count++),allList);
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
                   for (int k = j; k < sortStrArray.length - 1 ; k++){
                       if (sortRecordsMap.get(sortStrArray[k]) < sortRecordsMap.get(sortStrArray[k+1])){
                           temp = sortStrArray[k];
                           sortStrArray[k] = sortStrArray[k+1];
                           sortStrArray[k+1] = temp;
                       }else if (sortRecordsMap.get(sortStrArray[k]).equals(sortRecordsMap.get(sortStrArray[k+1]))){
                           if (sortStrArray[k].compareTo(sortStrArray[k+1]) < 0){
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
