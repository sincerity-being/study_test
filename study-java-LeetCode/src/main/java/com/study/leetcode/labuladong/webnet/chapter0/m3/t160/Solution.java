package com.study.leetcode.labuladong.webnet.chapter0.m3.t160;

import com.study.leetcode.datastruct.ListNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 00:57
 * @describe https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class Solution {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA; ListNode p2 = headB;
        while(p1 != p2){
            if(p1 == null){
                p1 = headB;
            }else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            }else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
