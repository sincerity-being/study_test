package com.study.leetcode.labuladong.webnet.chapter0.m3.t876;

import com.study.leetcode.datastruct.ListNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-04 23:57
 * @describe https://leetcode.cn/problems/middle-of-the-linked-list/description/
 */
public class Solution {

    public ListNode middleNode(ListNode head) {
       ListNode fast = head; ListNode slow = head;

       while( fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
       }
        // 慢指针指向中点
        return slow;
    }

}
