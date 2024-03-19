package com.study.leetcode.labuladong.webnet.chapter0.m5.te4;

import com.study.leetcode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 22:02
 * @describe 有些很明显需要用层序遍历技巧的二叉树的题目，也可以用递归遍历的方式去解决，
 * 而且技巧性会更强，非常考察你对前中后序的把控。
 *
 * 如果你对二叉树足够熟悉，可以想到很多方式通过递归函数得到层序遍历结果
 * 这种思路从结果上说确实可以得到层序遍历结果，但其本质还是二叉树的前序遍历，或者说 DFS 的思路，
 * 而不是层序遍历，或者说 BFS 的思路。因为这个解法是依赖前序遍历自顶向下、自左向右的顺序特点得到了正确的结果。
 */
public class Solution1 {
    List<List<Integer>> res = new ArrayList<>();

    List<List<Integer>> levelTraverse(TreeNode root) {
        if (root == null) {
            return res;
        }
        // root 视为第 0 层
        traverse(root, 0);
        return res;
    }

    void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 前序位置，看看是否已经存储 depth 层的节点了
        if (res.size() <= depth) {
            // 第一次进入 depth 层
            res.add(new LinkedList<>());
        }
        // 前序位置，在 depth 层添加 root 节点的值
        res.get(depth).add(root.val);
        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }

}
