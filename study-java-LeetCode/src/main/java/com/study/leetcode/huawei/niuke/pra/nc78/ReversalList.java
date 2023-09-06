package com.study.leetcode.huawei.niuke.pra.nc78;


import com.study.leetcode.datastruct.ListNode;
import com.study.leetcode.util.InputOutputUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-17 20:40
 * @describe
 * 自己创建的实现方法
 *
 */
public class ReversalList {



    public ListNode reverseList(ListNode head) {

        /**
         *  if (head == null){
         *             return null;
         *         }
         *          ListNode point = head;
         *          ListNode reverseHead ;
         *          ArrayList<ListNode> list = new ArrayList<>(10);
         *          while(point.next != null){
         *              list.add(point);
         *              point = point.next;
         *          }
         *          reverseHead = point;
         *          ListNode tempHead = reverseHead;
         *          for (int i = list.size()-1; i >= 0; i--){
         *              ListNode add = list.get(i);
         *              add.next = null;
         *              tempHead.next = add;
         *              tempHead = tempHead.next;
         *          }
         *           return reverseHead;
         *     }
         */
        if (head == null){
            return null;
         }
         ListNode point = head;
         ListNode reverseHead ;
         ArrayList<ListNode> list = new ArrayList<>(10);
         while(point.getNext() != null){
             list.add(point);
             point = point.getNext();
         }
         reverseHead = point;
         ListNode tempHead = reverseHead;
         for (int i = list.size()-1; i >= 0; i--){
             ListNode add = list.get(i);
             add.setNext(null);
             tempHead.setNext(add);
             tempHead = tempHead.getNext();
         }
          return reverseHead;
    }





}

