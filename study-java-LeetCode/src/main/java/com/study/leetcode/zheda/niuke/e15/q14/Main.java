package com.study.leetcode.enterprise.zheda.niuke.e15.q14;


import com.study.leetcode.enterprise.zheda.niuke.domain.Node;
import com.study.leetcode.enterprise.zheda.niuke.util.OperationNodeUtil;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-08 18:08
 * @describe https://www.nowcoder.com/questionTerminal/377f802665b4454cabd28bf1d2f554e5
 */
public class Main {

    public static void main(String[] args) {
        Node head = OperationNodeUtil.generateListNode();
        RemoveNodeList removeNodeList = new RemoveNodeList();
        removeNodeList.removeFunc(head, 21);

        OperationNodeUtil.showListNode(head);

    }




}
