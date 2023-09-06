package com.study.leetcode.enterprise.zheda.niuke.domain;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-08 17:51
 * @describe
 */
public class Node {
    private  int data;
    private  Node next = null;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int data, Node node) {
        this.data = data;
        this.next = node;
    }

    public Node(int data) {
        this.data = data;
    }
}
