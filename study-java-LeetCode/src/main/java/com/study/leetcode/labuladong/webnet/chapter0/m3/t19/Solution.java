package com.study.leetcode.labuladong.webnet.chapter0.m3.t19;

import com.study.leetcode.datastruct.ListNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-04 14:21
 * @describe https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 */
public class Solution {

    /**
     * 正常情况下要分类讨论的! 删除第一个节点 怎么办, 有了虚拟节点,现在不需要了
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;

        ListNode preNode = findFromEnd(dumpy, n+1);
        preNode.next = preNode.next.next;
        return dumpy.next;

    }

    private ListNode findFromEnd(ListNode dumpy, int k) {
        if (dumpy == null){
            return null;
        }
        ListNode p1 = dumpy;
        for (int i = 0; i < k; i++){
            p1 = p1.next;
        }
        ListNode p2 = dumpy;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


}
