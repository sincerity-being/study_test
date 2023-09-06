package com.study.leetcode.util;

import com.study.leetcode.datastruct.TreeNode;

import java.util.LinkedList;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-03 12:19
 * @describe
 */
public class OperateTreeUtil {

    public static void generateTreeBfs(TreeNode root, String[] splitStr, int index) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        while(index + 1 <= splitStr.length - 1){
            if (root == null){
                return;
            }
            if (index+1 > splitStr.length-1){
                return;
            }
            String leftStr = splitStr[index+1];
            if(! "#".equals(leftStr)){
                root.setLeft(new TreeNode(Integer.parseInt(leftStr)));
                queue.addLast(root.getLeft());
            }
            if (index + 2 > splitStr.length-1){
                return;
            }
            String rightStr = splitStr[index + 2];
            if (! "#".equals(rightStr)){
                root.setRight(new TreeNode(Integer.parseInt(rightStr)));
                queue.addLast(root.getRight());
            }
            root = queue.removeFirst();
            index = index + 2;
        }
    }
}
