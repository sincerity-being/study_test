package com.study.algorithmbook.book1.chapter03.list;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
public class ListRemoveDemo {

    public static void main(String[] args) {

    }

    public static void removeEvensVer1(List<Integer> lst) {
        int i = 0;
        while (i < lst.size()) {
            if (lst.get(i) % 2 == 0) {
                lst.remove(i);
            } else {
                i++;
            }
        }
    }

    public static void removeEvensVer2(List<Integer> lst) {
        for (Integer x : lst) {
            if (x % 2 == 0) {
                lst.remove(x);
            }
        }
    }

    public static void removeEvensVer3(List<Integer> lst) {
        lst.removeIf(x -> x % 2 == 0);
    }

    public static void removeEvensVer4(List<Integer> lst) {
        Iterator<Integer> itr = lst.iterator();
        while (itr.hasNext()) {
            if (itr.next() % 2 == 0) {
                itr.remove();
            }
        }
    }


}
