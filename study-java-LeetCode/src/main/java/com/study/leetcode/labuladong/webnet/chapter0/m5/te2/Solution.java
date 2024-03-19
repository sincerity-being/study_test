package com.study.leetcode.labuladong.webnet.chapter0.m5.te2;

import com.study.leetcode.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 16:01
 * @describe 分解思想
 */
public class Solution {

    // 定义：输入一棵二叉树的根节点，返回这棵树的前序遍历结果
    List<Integer> preorderTraverse(TreeNode root) {
        List<Integer> array = new LinkedList<>();
        if (root == null) {
            return array;
        }
        array.add(root.val);
        array.addAll(preorderTraverse(root.left));
        array.addAll(preorderTraverse(root.right));
        return array;
    }
}
