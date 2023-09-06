package com.study.leetcode.mydailytopic.let.chapter19;

import com.study.leetcode.datastruct.ListNode;

import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2023-03-01 10:21
 * @describe https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode x = findKNode(dumpy, n + 1);
        x.next = x.next.next;

        return dumpy.next;
    }

    public ListNode findKNode(ListNode head, int k){
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k; i++){
            p1 = p1.next;
        }
        while(p1  != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }


}
