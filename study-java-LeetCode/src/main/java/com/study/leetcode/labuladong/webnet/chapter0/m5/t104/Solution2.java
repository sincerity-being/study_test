package com.study.leetcode.labuladong.webnet.chapter0.m5.t104;

import com.study.leetcode.datastruct.TreeNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 15:45
 * @describe 你也很容易发现一棵二叉树的最大深度可以通过子树的最大深度推导出来，这就是分解问题计算答案的思路。
 */
public class Solution2 {



    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;

    }
}
