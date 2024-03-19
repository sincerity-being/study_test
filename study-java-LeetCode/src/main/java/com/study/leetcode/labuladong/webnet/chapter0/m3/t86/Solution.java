package com.study.leetcode.labuladong.webnet.chapter0.m3.t86;

import com.study.leetcode.datastruct.ListNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-04 00:07
 * @describe  https://leetcode.cn/problems/partition-list/
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {

        ListNode dumpy1 = new ListNode(-1);
        ListNode dumpy2 = new ListNode(-1);

        ListNode p1 = dumpy1, p2 = dumpy2, p = head;

        while (p != null){
            if (p.val < x){
                p1.next = p;
                p1 = p1.next;
            }else {
                p2.next = p;
                p2 = p2.next;
            }

            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dumpy2.next;
        return dumpy1.next;
    }

}
