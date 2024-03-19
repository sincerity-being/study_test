package com.study.leetcode.labuladong.webnet.chapter0.m5.te4;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-06 11:53
 * @describe
 */
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution3 {
    public int[][] levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        int[][] res = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            res[i] = new int[result.get(i).size()];
            for (int j = 0; j < result.get(i).size(); j++) {
                res[i][j] = result.get(i).get(j);
            }
        }
        return res;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution3 solution = new Solution3();
        int[][] result = solution.levelOrder(root);
        for (int[] arr : result) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
