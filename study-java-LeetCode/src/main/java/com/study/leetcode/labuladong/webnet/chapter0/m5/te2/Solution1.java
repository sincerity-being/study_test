package com.study.leetcode.labuladong.webnet.chapter0.m5.te2;

import com.study.leetcode.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 16:05
 * @describe 遍历思想
 */
public class Solution1 {

    List<Integer> res = new LinkedList<>();
    List<Integer> preorderTraverse(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
