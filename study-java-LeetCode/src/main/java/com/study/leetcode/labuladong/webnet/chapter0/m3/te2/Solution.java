package com.study.leetcode.labuladong.webnet.chapter0.m3.te2;

import com.study.leetcode.datastruct.ListNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 00:23
 * @describe 算法技巧: 快慢指针:  判断是否有环
 */
public class Solution {

    boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                return true;
            }
        }

        return false;
    }
}
