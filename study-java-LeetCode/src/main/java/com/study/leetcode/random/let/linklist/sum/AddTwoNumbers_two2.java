package com.study.leetcode.random.let.linklist.sum;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-04-02 09:35
 * @describe  解法 2
 */
public class AddTwoNumbers_two2 {

    public ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
        ListNode1 head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode1(sum % 10);
            } else {
                tail.next = new ListNode1(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode1(carry);
        }
            return head;
    }

    public static void main(String[] args) {
        ListNode1 listNode1_1 = new ListNode1(9);
        ListNode1 listNode1_2 = new ListNode1(9);
        ListNode1 listNode1_3 = new ListNode1(9);
        ListNode1 listNode1_4 = new ListNode1(9);
        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;
        listNode1_3.next = listNode1_4;

        ListNode1 listNode2_1 = new ListNode1(9);
        ListNode1 listNode2_2 = new ListNode1(9);
        ListNode1 listNode2_3 = new ListNode1(9);
        ListNode1 listNode2_4 = new ListNode1(9);
        listNode2_1.next = listNode2_2;
        listNode2_2.next = listNode2_3;
        listNode2_3.next = listNode2_4;

      ListNode1 result =  new AddTwoNumbers_two2().addTwoNumbers(listNode1_1,listNode2_1);
      ListNode1 tmp = result;
     while(tmp != null ){
         System.out.println(tmp.val);
         tmp = tmp.next;
     }

    }
}

/**
 * Definition for singly-linked list.
 *
 */
class ListNode1 {
     int val;
     ListNode1 next;
     ListNode1() {}
     ListNode1(int val) { this.val = val; }
     ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
 }
