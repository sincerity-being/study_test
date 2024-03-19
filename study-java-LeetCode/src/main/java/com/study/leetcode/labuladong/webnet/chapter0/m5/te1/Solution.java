package com.study.leetcode.labuladong.webnet.chapter0.m5.te1;

import com.study.leetcode.datastruct.ListNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 14:45
 * @describe
 * 比如说，如果让你倒序打印一条单链表上所有节点的值，你怎么搞？
 *
 * 实现方式当然有很多，但如果你对递归的理解足够透彻，可以利用后序位置来操作：
 * 你应该知道为什么这段代码能够倒序打印单链表了吧，本质上是利用递归的堆栈帮你实现了倒序遍历的效果。
 */
public class Solution {

    public void traverse(ListNode head) {
        if (head == null){
            return;
        }
        traverse(head.next);
        System.out.println(head.val);
    }

}
