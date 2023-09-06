package com.study.leetcode.enterprise.huawei.niuke.jishi.hj0;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-06 19:30
 * @describe
 */
public class Hj002 {

    public static void main(String[] args) {
        // 1. 定义一个字符串
        String s = "abcdekka27qoq";
        // 2. 将字符串中的每一个字符转换成一个字符数组
        char[] ch = s.toCharArray();
        // 3. 创建一个Map集合,用于存储字符与出现次数的关系
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        // 4. 遍历ch数组,将字符串中的每一个字符获取到,判断是不是数字
        // 0-9--->48-57   a-z 97-122  A-Z 65-90
        for(char c : ch) {

            if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                // 5. 判断当前的字符c是不是第一次存储在map中
                // 1) 第一次存储 : 计数1
                // 2) 不是第一次存储 : 原有计数+1
                if(map.containsKey(c)) {
                    map.put(c, map.get(c)+1);
                }else{
                    map.put(c, 1);
                }
            }
        }

        System.out.println(map);

        //6. 需要将value的值从大到小进行输出
        // 遍历map集合,每次将map中的最大value值获取到,输出value和key,循环进行输出

        Set<Character> set= map.keySet();// 获取到map集合中的所有key值

        while(!map.isEmpty()) {
            // 7. 通过遍历每一个key的值,获取到对应的value值
            int maxValue = 0;
            Character maxZiFu = null;
            for(Character cha : set) {
                int value= map.get(cha);
                if(value > maxValue) {// 为了将当前map集合中的最大值获取到
                    maxValue = value;
                    maxZiFu = cha;
                }
            }

            System.out.println(maxZiFu + "==" + maxValue);
            // 8. 将最大的键值对输出之后,从map集合中删除
            map.remove(maxZiFu);
        }

    }

}
