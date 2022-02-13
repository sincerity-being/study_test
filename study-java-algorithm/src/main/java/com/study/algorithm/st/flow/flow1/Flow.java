package com.study.algorithm.st.flow.flow1;

import java.util.*;

/**
 * @author: XH
 * @date: 2020/7/16 7:12
 * @describe:
 * @vision
 */
public class Flow {


    /**
     * 分流
     *
     * @param record     发送记录列表
     * @param weightInfo 权重列表
     * @param num        单次发送数量
     * @return 每个渠道分配数量的list
     * <p>
     * record列表会被改变,如果不希望改变可传入record的copy
     */
    public List<Integer> doFlow(List<Long> record, List<Integer> weightInfo, Integer num) {
        //返回的list
        ArrayList<Integer> res = new ArrayList<>();
        //发送条数分配情况
        Integer count = 0;
        //确定发送总数
        double allNum = 0;
        //首次分配
        for (int i = 0; i < weightInfo.size(); i++) {
            Integer weight = weightInfo.get(i);
            //单次发送2000w以上可能会数据溢出
            int weightNum = (num * weight) / 100;
            res.add(weightNum);
            record.set(i, record.get(i) + weightNum);
            //统计出分配后发送总数
            allNum = allNum + record.get(i);
            //统计分配情况
            count = count + weightNum;
        }
//        System.out.println(res);
//        System.out.println(count);
        //表示没有分完
        if (!count.equals(num)) {
            //key:表示接近设置权重的程度,value:表示record或res的下标
            TreeMap<String, Integer> treeMap = new TreeMap<>(Collections.<String>reverseOrder());
            //计算出剩余发送条数
            count = num - count;
            //设置每个渠道接近设置权重的程度,同时排序(倒序排)
            for (int i = 0; i < record.size(); i++) {
                Long recordNum = record.get(i);
                //设置权重 - 当前权重
                double rate = weightInfo.get(i) / 100.0 - recordNum / allNum;
                //接近程度相同,可能会出现key值相同情况,加上i作为后缀避免重复,大小影响忽略不计
                treeMap.put(rate + "" + i, i);
            }
//            System.out.println("treeMap:"+treeMap);
            //第二次分配
            Set<String> keySet = treeMap.keySet();
           /* for (String key : keySet) {
                //渠道列表的下标
                Integer lie = treeMap.get(key);
                if (count > 0) {
                    res.set(lie, res.get(lie) + 1);
                    record.set(lie, record.get(lie) + 1);
                    count--;
                } else {
                    break;
                }
            }*/

           while(count >0 ){
               for (String key : keySet) {
                   //渠道列表的下标
                   Integer lie = treeMap.get(key);
                   if (count > 0) {
                       res.set(lie, res.get(lie) + 1);
                       record.set(lie, record.get(lie) + 1);
                       count--;
                   } else {
                       break;
                   }
               }
           }
        }
        return res;
    }


    public static void main(String[] args) {

        ArrayList<Long> record = new ArrayList<>();
        ArrayList<Integer> weightInfo = new ArrayList<>();

        //之前该分流渠道的发送情况,long类型
        record.add(100l);
        record.add(110l);
        record.add(120l);

       /* record.add(0L);
        record.add(0l);
        record.add(0l);*/
        //分流渠道权重,加和为100,个数和record长度相同
        weightInfo.add(40);
        weightInfo.add(10);
        weightInfo.add(50);

        Flow flow = new Flow();
        Random random = new Random();

        //测试

        //模拟发送总数
        long all = 0;
        //模拟分流总数
        long flowAll = 0;

        //模拟1000次分流
        for (int i = 0; i < 1000; i++) {
            //发送数量为随机值
            int num = random.nextInt(100);
            List<Integer> list = flow.doFlow(record, weightInfo, num);

            all = all + num;
            System.out.println("num:" + num);
            System.out.println("flow: " + list);
            System.out.println("record: " + record);
            long sum = 0;
            for (Long val : record) {
                sum = sum + val;
            }
            //每个渠道发送比例
            for (Long val : record) {
                System.out.print(val / (double) sum + " ");
            }
            System.out.println();

            //分流总数
            for (int j = 0; j < list.size(); j++) {
                flowAll = flowAll + list.get(j);
            }

        }
        System.out.println(all);
        System.out.println(flowAll);

        long allRecord = 0;
        for (int i = 0; i < record.size(); i++) {
            allRecord = allRecord + record.get(i);
        }
        System.out.println(allRecord);

    }


}
