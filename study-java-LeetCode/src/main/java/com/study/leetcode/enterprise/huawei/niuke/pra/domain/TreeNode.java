package com.study.leetcode.enterprise.huawei.niuke.pra.domain;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-17 17:22
 * @describe
 */
public class TreeNode {
    private int val = 0;
    private TreeNode left = null;
    private TreeNode right = null;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(int val){
        this.val = val;
    }
}
