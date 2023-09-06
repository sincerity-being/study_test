package com.study.leetcode.labuladong.chapter1.m1_lianbiao.ex1.t86;

import com.study.leetcode.datastruct.ListNode;

/**
 * 与题21情况类似 之前2023-3-1 学习labuladong时在leetcode平台上写过!但没有在这里备份
 * @author HeYQ
 * @version 1.0
 * @date 2023-08-22 14:31
 * @describe  https://leetcode.cn/problems/partition-list/
 */
public class Solution {
    /**
     * 先拆分
     * 先合并
     * 先拆分 后合并
     *
     * 注意判断是否断开原来节点连接!
     * @param head
     * @param x
     * @return
     */
    ListNode partition(ListNode head, int x) {
        ListNode dumpy1 = new ListNode(-1);
        ListNode dumpy2 = new ListNode(-1);
        ListNode p1 = dumpy1;
        ListNode p2 = dumpy2;
        ListNode p = head;
        ListNode temp;
        while(p != null){
            temp = p;
            if (p.val >= x){
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            p = p.next;
            temp.next = null;
        }
        p1.next = dumpy2.next;
        return dumpy1.next ;

    }


}
