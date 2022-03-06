package com.study.leetcode.enterprise.huawei.niuke.pra.nc14;

import com.study.leetcode.enterprise.huawei.niuke.pra.domain.TreeNode;
import com.study.leetcode.util.InputOutputUtil;
import com.study.leetcode.util.OperateTreeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-03 12:20
 * @describe 按之字形顺序打印二叉树
 * https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117%26page%3D1%26difficulty%3D3&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */
public class Main {

    public static void main(String[] args) {
        String[] splitStr = InputOutputUtil.nextInStringArrayOut();
        if (splitStr.length == 0){
            return;
        }
//        for (String str1 : splitStr){
//            System.out.print(str1 + " ");
//        }
        if (splitStr[0].compareTo("#") == 0){
            return;
        }
        //进行树的构造
        TreeNode root = new TreeNode(Integer.parseInt(splitStr[0]));
        OperateTreeUtil.generateTreeBfs(root, splitStr, 0);
        Fun1 fun1 = new Fun1();
        ArrayList<ArrayList<Integer>> list = fun1.searchGenerate(root);
        System.out.println(list);

        Fun2 fun2 = new Fun2();
        ArrayList<ArrayList<Integer>> lists = fun2.Print(root);
        System.out.println(lists);


    }


    private static void testHashMap() {
        Map<Integer, String> map = new HashMap<>(16);
        map.put(1,"123");
        map.put(1, "1234");
        for (Integer key : map.keySet()){
            System.out.println(map.get(key));
        }
    }
}
