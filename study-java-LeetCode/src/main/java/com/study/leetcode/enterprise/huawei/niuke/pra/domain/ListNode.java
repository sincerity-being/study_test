package com.study.leetcode.enterprise.huawei.niuke.pra.domain;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-17 20:41
 * @describe
 */
public class ListNode {
    private  int val;
    private ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
