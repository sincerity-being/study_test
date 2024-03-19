package com.study.leetcode.labuladong.webnet.chapter0.m3.t142;

import com.study.leetcode.datastruct.ListNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 00:30
 * @describe https://leetcode.cn/problems/linked-list-cycle-ii/description/
 */
public class Solution {

    public ListNode detectCycle(ListNode head){
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }

        if (fast == null || fast.next == null){
            return null;
        }

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
       return slow;
    }
}
