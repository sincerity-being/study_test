package com.study.leetcode.labuladong.webnet.chapter0.m5.te4;

import com.study.leetcode.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 22:01
 * @describe  二叉树题型主要是用来培养递归思维的，而层序遍历属于迭代遍历，也比较简单，这里就过一下代码框架吧： 层序遍历
 *
 * 后文 BFS 算法框架 就是从二叉树的层序遍历扩展出来的，常用于求无权图的最短路径问题。
 *
 * 当然这个框架还可以灵活修改，题目不需要记录层数（步数）时可以去掉上述框架中的 for 循环，
 * 比如后文 Dijkstra 算法 中计算加权图的最短路径问题，详细探讨了 BFS 算法的扩展。
 */
public class Solution {

    // 输入一棵二叉树的根节点，层序遍历这棵二叉树
    void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // 从上到下遍历二叉树的每一层
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 将下一层节点放入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }

}
