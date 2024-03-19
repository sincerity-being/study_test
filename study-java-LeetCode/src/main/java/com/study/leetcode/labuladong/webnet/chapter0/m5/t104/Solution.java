package com.study.leetcode.labuladong.webnet.chapter0.m5.t104;

import com.study.leetcode.datastruct.ListNode;
import com.study.leetcode.datastruct.TreeNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 15:27
 * @describe 二叉树的最大深度 https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 */
public class Solution {

    int depth = 0;
    int res = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);

        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth ++;
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }

        traverse(root.left);
        traverse(root.right);

        depth--;

    }
}
