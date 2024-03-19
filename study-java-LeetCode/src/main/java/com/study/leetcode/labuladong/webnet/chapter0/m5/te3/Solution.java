package com.study.leetcode.labuladong.webnet.chapter0.m5.te3;

import com.study.leetcode.datastruct.TreeNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 16:16
 * @describe
 */
public class Solution {

    // 二叉树遍历函数 如果把根节点看做第 1 层，如何打印出每一个节点所在的层数？
    void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 前序位置
        System.out.print("节点 " + root + "在第" + level + "层");
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }


    // 如何打印出每个节点的左右子树各有多少节点？
// 定义：输入一棵二叉树，返回这棵二叉树的节点总数
    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        // 后序位置
        System.out.printf("节点 %s 的左子树有 %d 个节点，右子树有 %d 个节点",
                root, leftCount, rightCount);

        return leftCount + rightCount + 1;

    }
}
