package com.study.leetcode.labuladong.webnet.chapter0.m3.t21;

import com.study.leetcode.datastruct.ListNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-03 23:27
 * @describe
 */
public class Solution2 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dumpy = new ListNode(-1), p = dumpy;
        ListNode p1 = list1; ListNode p2 = list2;
        while(p1 != null && p2 != null){
            if (p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        // 因为p1之前已经移动了.
        if (p1 != null){
            p.next = p1;
        }

        if(p2 != null){
            p.next = p2;
        }

        return dumpy.next;
    }




}
