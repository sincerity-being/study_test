package com.study.leetcode.huawei.niuke.exam.od.e2016;

import java.util.Scanner;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-08-27 11:49
 * @describe
 * https://www.nowcoder.com/test/question/f9533a71aada4f35867008be22be5b6e?pid=710802&tid=60294206
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sc = scanner.nextInt();
        if (sc == 1){
            System.out.println(0);
            return;
        }
        Node head = new Node();
        head.val = 0;
        Node p = head;
        for (int i =1; i < sc; i++){
           Node node = new Node();
           node.val = i;
           p.next = node;
        }






    }
}
class Node{
    int val;
    Node next;
}
