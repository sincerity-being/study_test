package com.study.leetcode.mydailytopic.let.chapter23;

import com.study.leetcode.datastruct.ListNode;

import java.util.PriorityQueue;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2023-03-01 09:46
 * @describe 合并K个升序链表 https://leetcode.cn/problems/merge-k-sorted-lists/
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }

        ListNode dumpy1 = new ListNode(-1);
        ListNode p = dumpy1;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
        for(ListNode listNode : lists){
              if(listNode != null){
                queue.add(listNode);
              }
        }
         while(!queue.isEmpty()){
             ListNode node = queue.poll();
             p.next = node;
             if (node.next != null){
                 queue.add(node.next);
             }
             p = p.next;
         }

         return dumpy1.next;

    }

}
