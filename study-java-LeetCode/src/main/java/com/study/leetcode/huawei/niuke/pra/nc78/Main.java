package com.study.leetcode.huawei.niuke.pra.nc78;


import com.study.leetcode.datastruct.ListNode;
import com.study.leetcode.util.InputOutputUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-03 12:23
 * @describe
 * 链表反转顺序
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=190&tqId=35203&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd&difficulty=&judgeStatus=&tags=/question-ranking
 *
 */
public class Main {

    public static void main(String[] args) {
        String[] splitStrArr = InputOutputUtil.nextInStringArrayOut();
        if (splitStrArr.length == 0){
            System.out.println("{ }");
            return;
        }
        ListNode head = new ListNode(Integer.parseInt(splitStrArr[0]));
        ListNode point = head;
        for (int i = 1; i < splitStrArr.length ; i++) {
            ListNode node = new ListNode(Integer.parseInt(splitStrArr[i]));
            while(point.getNext() != null){
                point = point.getNext();
            }
            point.setNext(node);
        }

        ReversalList reversalList = new ReversalList();
        point = reversalList.reverseList(head);
        List<Integer> list = new ArrayList<>(10);
        while(point != null){
            list.add(point.getVal());
            point = point.getNext();
        }
        System.out.println(list);
    }
}
