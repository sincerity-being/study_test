package com.study.leetcode.labuladong.webnet.chapter0.m5.t543;

import com.study.leetcode.datastruct.TreeNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 17:00
 * @describe
 */
public class Solution2 {

    // 记录最大直径的长度
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // 计算直径.
        maxDiameter = Math.max(maxDiameter, right + left);

        return Math.max(left, right) + 1;
    }
}
