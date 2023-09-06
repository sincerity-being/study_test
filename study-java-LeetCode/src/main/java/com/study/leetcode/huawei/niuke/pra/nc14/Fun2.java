package com.study.leetcode.huawei.niuke.pra.nc14;

import com.study.leetcode.datastruct.TreeNode;

import java.util.*;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-17 17:09
 * @describe 自己创造实现的方法二
 */
public class Fun2 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        bfsSearch(pRoot,list);
        for(int i=0;i<list.size();i++){
            if(i%2!=0){
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }

    private void bfsSearch(TreeNode root, ArrayList<ArrayList<Integer>> list) {
        if(root==null){
            return;
        }
        Map<Integer, LinkedList<TreeNode>> mapDeque = new HashMap<>(16);
        ArrayList<Integer> sunFirstList = new ArrayList<>(16);
        sunFirstList.add(root.getVal());
        list.add(sunFirstList);
        LinkedList<TreeNode> firstQueue = new LinkedList<>();
        firstQueue.addLast(root);
        int depth = 0;
        mapDeque.put(depth,firstQueue);

        while(!mapDeque.isEmpty()){
            LinkedList<TreeNode> queue = mapDeque.remove(depth++);
            LinkedList<TreeNode> addQueue = new LinkedList<>();
            ArrayList<Integer> subList = new ArrayList<>(10);
             while(!queue.isEmpty()){
                  root = queue.removeFirst();
                  TreeNode left = root.getLeft();
                 if (left != null){
                     subList.add(left.getVal());
                     addQueue.addLast(left);
                 }
                 TreeNode right = root.getRight();
                 if (right != null){
                     subList.add(right.getVal());
                     addQueue.addLast(right);
                 }
             }
             if (!subList.isEmpty()){
                 list.add(subList);
             }
            if (!addQueue.isEmpty()){
                mapDeque.put(depth, addQueue);
            }

        }
    }

}
