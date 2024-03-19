package com.study.leetcode.labuladong.webnet.chapter0.m3.t23;

import com.study.leetcode.datastruct.ListNode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-04 09:46
 * @describe https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dumpy = new ListNode(-1);
        ListNode p = dumpy;
        Queue<ListNode> queue = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));

        for(ListNode head : lists){
            if (head != null) {
                queue.add(head);
            }
        }

        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null){
                queue.add(node.next);
            }

            p = p.next;
        }

         return dumpy.next;
    }


}
