package com.study.leetcode.labuladong.webnet.chapter1.m1_lianbiao.ex1.t21;

import com.study.leetcode.datastruct.ListNode;

/**
 * 之前的(2023.02.28)labuladong  leetcode21 题 应该是直接在leetcode上提交了 没有在这里留存!
 * 而leetcode23题在 mydailytopic中有 现在那个当成 二次学习
 * @author HeYQ
 * @version 1.0
 * @date 2023-08-22 12:19
 * @describe  https://leetcode.cn/problems/merge-two-sorted-lists/
 *
 * 关键点: 虚拟节点
 * 双指针
 */
public class Solution {

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //1) 因为是要创建一个新的链表 创建一个虚拟节点 方便处理边界问题
        ListNode dumpy = new ListNode(-1);
        // 2) 使用双指针的威力
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = dumpy;

        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                p.next = p2;
                p2 = p2.next;
            }else{
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null){
            p.next = p1;
        }
        if (p2 != null){
            p.next = p2;
        }
        return dumpy.next;
    }





}
