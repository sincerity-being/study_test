package com.study.algorithm.shangguigu.review.dataStructures.linkedlist.singlelist;

import com.study.algorithm.shangguigu.review.dataStructures.linkedlist.domain.HeroNode;
import com.study.algorithm.shangguigu.review.dataStructures.linkedlist.domain.SingleLinkedList;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-14 09:35
 * @describe
 */
public class Main {

    public static void main(String[] args) {
          //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        // 测试一下单链表的反转功能
        System.out.println("原来链表的情况~~");
        singleLinkedList.list();

          //测试一下 求单链表中有效节点的个数
        SingleListDemo singleListDemo = new SingleListDemo();
        System.out.println("有效的节点个数=" + singleListDemo.getLength(singleLinkedList.getHead()));

        //测试一下看看是否得到了倒数第K个节点
        HeroNode res = singleListDemo.findLastIndexNode(singleLinkedList.getHead(), 3);
        System.out.println("res=" + res);


        System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
        singleListDemo.reversePrint(singleLinkedList.getHead());

        System.out.println("反转单链表~~");
        singleListDemo.reverseList(singleLinkedList.getHead());
		singleLinkedList.list();


    }
}
