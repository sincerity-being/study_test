package com.study.leetcode.enterprise.zheda.niuke.util;

import com.study.leetcode.enterprise.zheda.niuke.domain.Node;
import com.study.leetcode.util.InputOutputUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-08 18:11
 * @describe
 */
public class OperationNodeUtil {


    /**
     * 输入 {1, 2,5,6} 生成 单链表 有头节点
     * @return
     */
    public static Node generateListNode(){
        String[] splitStrArr = InputOutputUtil.nextInStringArrayOut();
        if (splitStrArr.length == 0){
            System.out.println("{ }");
            return null;
        }
        Node head = new Node(0);
        Node point = head;
        for (String s : splitStrArr) {
            Node node = new Node(Integer.parseInt(s));
            while (point.getNext() != null) {
                point = point.getNext();
            }
            point.setNext(node);
        }
        return head;
    }

    /**
     *  头节点不会打印出来的
     * @param head
     */
    public static void showListNode(Node head){
        List<Integer> list = new ArrayList<>(10);
        if (head == null){
            System.out.println("empty list");
            return;
        }
        Node point = head;
        while(point.getNext() != null){
            list.add(point.getNext().getData());
            point = point.getNext();
        }
        System.out.println(list);
    }




}
