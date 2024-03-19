package com.study.leetcode.labuladong.webnet.chapter0.m3.te1;

import com.study.leetcode.datastruct.ListNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-04 10:59
 * @describe 算法技巧: 快慢指针组合!
 */
public class Solution {

//  返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        if (head == null){
            return null;
        }
        ListNode p1 = head;
        for (int i = 0; i < k; i++){
            p1 = p1.next;
        }

        ListNode p2 = head;

        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }




}
