package com.study.basic.collection.reverse;

import java.util.*;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-16 16:50
 *@describe:类 Collections
 *   reverseOrder()
 *   返回一个比较器，它强行逆转实现了 Comparable 接口的对象 collection 的自然顺序。
 *   reverseOrder(Comparator<T> cmp)
 *   返回一个比较器，它强行逆转指定比较器的顺序。
 *@version:
 */
public class CollectionRerverseDemo  {

    public static void main(String[] args) {
       // Set<String> set = new TreeSet<>();
         // Set<String> set = new TreeSet<>(Collections.reverseOrder());

        //根据字符串长度排序
        Set<String> set = new TreeSet<String>(Collections
                .reverseOrder(new StringLengthSort()));
        set.add("abcde");
        set.add("aaa");
        set.add("kkk");
        set.add("ccc");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }



}

/*
 * 根据字符串长度进行排序
 */
class StringLengthSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int num = new Integer(o1.length()).compareTo(new Integer(o2.length()));
        if (num == 0) {
            return o1.compareTo(o2);
        }
        return num;
    }
}
