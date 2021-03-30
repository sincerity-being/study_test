package com.java.collection.listsame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-16 21:09
 *@describe:
 *@version:
 */
public class IsListSame {

    public static void main(String[] args) {

        String str = "1,1,2,3,4";
        System.out.println(judgeIsStrSame(str));
    }

    /***
     *
     * @param str
     * @return
     */
    public  static boolean judgeIsStrSame(String str){

        String[] strSplit = str.split(",");
        List<String> strs = Arrays.asList(strSplit);
        Set<String> stringSet = new HashSet<>(strs);


        return strs.size() != stringSet.size()? true :false;
    }





}
