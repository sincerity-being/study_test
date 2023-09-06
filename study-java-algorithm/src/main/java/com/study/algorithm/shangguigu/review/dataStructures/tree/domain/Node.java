package com.study.algorithm.shangguigu.review.dataStructures.tree.domain;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-16 19:38
 * @describe 创建结点类
 *  为了让Node 对象持续排序Collections集合排序
 *  让Node 实现Comparable接口
 */
public class Node implements Comparable<Node> {

    // 存放数据(字符)本身，比如'a' => 97 ' ' => 32
    private Byte data;

    // 结点权值
    private int weight;

    //字符
   private  char c;

    // 指向左子结点
   private Node left;

    // 指向右子结点
   private Node right;

    //写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "Node [data = " + data + " weight=" + weight + "]";
    }

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.weight - o.weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

