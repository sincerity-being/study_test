package com.study.leetcode.labuladong.webnet.chapter0.m3.t21;

import com.study.leetcode.datastruct.ListNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-03 22:27
 * @describe https://leetcode.cn/problems/merge-two-sorted-lists/description/
 *
 * 要点指针移动!
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ListNode dumpy = new ListNode(-1), p = dumpy;
         ListNode l1 = list1; ListNode l2 = list2;

         while (l1 != null && l2 != null){
             if (l1.val < l2.val) {
                 p.next = l1;
                 l1 = l1.next;
             } else {
                 p.next = l2;
                 l2 = l2.next;
             }

             p = p.next;
         }

         if (l1 != null){
             p.next = l1;
         }

         if (l2 != null){
             p.next = l2;
         }

         return dumpy.next;
    }
}
