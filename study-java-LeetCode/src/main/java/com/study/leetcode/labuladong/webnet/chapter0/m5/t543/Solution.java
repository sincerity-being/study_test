package com.study.leetcode.labuladong.webnet.chapter0.m5.t543;

import com.study.leetcode.datastruct.TreeNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 16:36
 * @describe https://leetcode.cn/problems/diameter-of-binary-tree/submissions/507921464/
 */
public class Solution {

     int myDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       traverse(root);
        return myDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    private void traverse(TreeNode root) {
        if(root == null) {
            return;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        myDiameter = Math.max(myDiameter, left + right);

        traverse(root.left);
        traverse(root.right);

    }

}
