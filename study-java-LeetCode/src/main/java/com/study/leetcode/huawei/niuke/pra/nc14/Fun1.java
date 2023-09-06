package com.study.leetcode.huawei.niuke.pra.nc14;

import com.study.leetcode.datastruct.TreeNode;

import java.util.*;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-13 16:37
 * @describe
 * 自己参考别人实现的方法一
 *
 */
public class Fun1 {


   // [1, #, #] 没有办法成树
    private static void generateTree(TreeNode root, String[] splitStr, int index) {
        if (root == null){
            return;
        }
        if (index+1 > splitStr.length-1){
            return;
        }
        String leftStr = splitStr[index+1];
        if(! "#".equals(leftStr)){
            root.setLeft(new TreeNode(Integer.parseInt(leftStr)));
        }
        if (index + 2 > splitStr.length-1){
            return;
        }
        String rightStr = splitStr[index + 2];
        if (! "#".equals(rightStr)){
            root.setRight(new TreeNode(Integer.parseInt(rightStr)));
        }
    }

    /**
     * 深度优先遍历
     * @param pRoot
     * @return
     */
    public  ArrayList<ArrayList<Integer>> searchGenerate(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(10);
        depth(pRoot, 1 , list);
        for (int i = 0; i < list.size(); i++) {
            if(i % 2 != 0){
                Collections.reverse(list.get(i));
            }
        }
        return  list;
    }

    private void depth(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> list) {
        if(pRoot == null){
            return;
        }
        if(depth > list.size()){
            ArrayList<Integer> deptList = new ArrayList<>(10);
            list.add(deptList);
        }
        list.get(depth-1).add(pRoot.getVal());
        depth(pRoot.getLeft(), depth+1, list);
        depth(pRoot.getRight(), depth+1, list);
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        // 使用广度优先遍历.

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot,0,list);
        for(int i=0;i<list.size();i++){
            if(i%2!=0){
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }



}
