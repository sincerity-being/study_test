package com.study.leetcode.enterprise.huawei.niuke.jishi.hj26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-07-07 09:21
 * @describe
 */
public class H2601 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = "";
        while ((original = br.readLine()) != null) {

            // 遍历字符串并存入TreeMap中
            TreeMap<Character, StringBuilder> map = new TreeMap<>();
            for (char c: original.toCharArray()) {
                if ('a' <= c && c <= 'z') {
                    if (!map.containsKey(c)) {
                        map.put(c, new StringBuilder());
                    }
                    map.get(c).append(c);
                } else if ('A' <= c && c <= 'Z') {
                    char k = (char)(c - 'A' + 'a');
                    if (!map.containsKey(k)) {
                        map.put(k, new StringBuilder());
                    }
                    map.get(k).append(c);
                }
            }

            // 将已排序好的字母部分合并
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, StringBuilder> entry: map.entrySet()) {
                sb.append(entry.getValue());
            }

            // 重新遍历字符串以插入非字母的字符
            for (int i = 0; i < original.length(); i++) {
                char other = original.charAt(i);
                if ('a' <= other && other <= 'z') {
                    continue;
                } else if ('A' <= other && other <= 'Z') {
                    continue;
                } else {
                    sb.insert(i, other);
                }
            }
            System.out.println(sb.toString());
        }
        br.close();
    }
}
