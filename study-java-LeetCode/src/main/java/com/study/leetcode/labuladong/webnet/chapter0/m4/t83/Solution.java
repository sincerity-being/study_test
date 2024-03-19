package com.study.leetcode.labuladong.webnet.chapter0.m4.t83;

import com.study.leetcode.datastruct.ListNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-05 10:27
 * @describe https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
          if (head == null) {
              return null;
          }
          ListNode fast = head, slow = head;

          while (fast != null) {

              if (slow.val != fast.val) {
                  slow.next = fast;
                  slow = slow.next;
              }
              fast = fast.next;
          }

          slow.next = null;
          return head;
    }

}
