package com.study.leetcode.mydailytopic.let.chapter02;
/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-04-02 09:56
 * @describe 我的第一种解法
 * 该题目要考察的所谓 逆序排列 是啥 ===> 要重点搞清楚
 *  1) 以前的加法是 从右往左加. == > 现在 就是 从左往右加 ==> 即所谓的逆序加
 *  --- 这个是整个解题的思路.
 *  2) 其他细节
 *    (1) 考虑进位 结果放啥 进位放啥.
 *    (2) 长度不一致的处理.
 *    (3) 没有造链表对象 (利用链表规则解题)
 *    (4) 最后的进位不为0的处理.
 *    (5) 结果处理 header tail header 不动, tail 往后移动.
 */
public class AddTwoNumbers1 {

    static class ListNode{
        int val ;
        ListNode next;
        public ListNode(){}
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val , ListNode next){
            this.val = val;
            this.next = next;
        }

    }


    public ListNode addTwoNumbers(ListNode l1 , ListNode l2){
        // 声明 存储结果的
        ListNode header = null , tail = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int n1 = (l1 == null ? 0 : l1.val);
            int n2 = (l2 == null ? 0 : l2.val);
            int sum = n1 + n2 + carry;
            // 处理结果
            if (header == null){
               header = new ListNode(sum % 10);
               tail = header;
            }else{
               tail.next = new ListNode(sum % 10);
               // 移动指针
               tail = tail.next;
            }
            // 进行进位
            carry = sum / 10;

            if (l1 != null){
                l1 = l1.next;
            }
          if (l2 != null){
              l2 = l2.next;
          }
        }

        if (carry != 0){
            tail.next = new ListNode(carry);
        }


        return header;
    }

    public static void main(String[] args) {
        ListNode listNode1_1 = new ListNode(9);
        ListNode listNode1_2 = new ListNode(9);
        ListNode listNode1_3 = new ListNode(9);
        ListNode listNode1_4 = new ListNode(9);
        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;
        listNode1_3.next = listNode1_4;

        ListNode listNode2_1 = new ListNode(9);
        ListNode listNode2_2 = new ListNode(9);
        ListNode listNode2_3 = new ListNode(9);
        ListNode listNode2_4 = new ListNode(9);
        listNode2_1.next = listNode2_2;
        listNode2_2.next = listNode2_3;
        listNode2_3.next = listNode2_4;

        ListNode result = new AddTwoNumbers1().addTwoNumbers(listNode1_1, listNode2_1);
        ListNode tmp = result;
        while(tmp != null ){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }


}
