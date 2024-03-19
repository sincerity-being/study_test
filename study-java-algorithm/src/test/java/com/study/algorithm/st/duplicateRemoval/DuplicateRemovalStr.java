package com.study.algorithm.st.duplicateRemoval;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 *java -- 去除字符串重复字符
 *https://blog.csdn.net/qq_29373285/article/details/84940771?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.edu_weight&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.edu_weight
 *@author: HeYQ
 *@date: 2020-07-16 20:57
 *@describe:
 *@version:
 */
public class DuplicateRemovalStr {

    /**
     * 过滤字符串重复
     * @param str
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static String filterRepetition(String str) {
        String[] a = str.split(",");
        List list = Arrays.asList(a);
        Set set = new HashSet(list);
       // a=(String [])set.toArray(new String[0]);

        str = StringUtils.join(set,",");
        return str;
    }

    /**
     * 过滤字符串重复,返回数组
     * @param str
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static String[] filterRepetitionToArray(String str) {
        String[] a = str.split(",");
        List list = Arrays.asList(a);
        Set set = new HashSet(list);
        a=(String [])set.toArray(new String[0]);
        return a;
    }

    public static void main(String[] args) {
        String str = "1,1,122,3";
        System.out.println("====" +filterRepetition(str) );
    }

}
