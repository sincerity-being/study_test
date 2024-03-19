package com.study.leetcode.labuladong.webnet.chapter0.m5.t104;

import com.study.leetcode.datastruct.TreeNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 15:39
 * @describe
 */
public class Solution1 {

    int depth = 0;
    int res = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);

        return res;
    }

    void traverse(TreeNode root){

        if (root == null) {
            return;
        }

        depth ++;
        // 当前节点是叶子节点 更新 res
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);

        depth --;
    }

}
