package com.study.algorithm.shangguigu.review.dataStructures.linkedlist.singlelist;

import com.study.algorithm.shangguigu.review.dataStructures.linkedlist.domain.HeroNode;

import java.util.Stack;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-14 09:33
 * @describe
 */
public class SingleListDemo {


    //方法：获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
    /**
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public  int getLength(HeroNode head) {
        if(head.next == null) { //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode cur = head.next;
        while(cur != null) {
            length++;
            cur = cur.next; //遍历
        }
        return length;
    }

    //查找单链表中的倒数第k个结点 【新浪面试题】
    //思路
    //1. 编写一个方法，接收head节点，同时接收一个index
    //2. index 表示是倒数第index个节点
    //3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    //4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    //5. 如果找到了，则返回该节点，否则返回 null
    public  HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空，返回null //没有找到
        if(head.next == null) {
            return null;
        }
        //第一个遍历得到链表的长度(节点个数)
        int size = getLength(head);
        //第二次遍历  size-index 位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if(index <=0 || index > size) {
            return null;
        }
        //定义给辅助变量， for 循环定位到倒数的index
        //3 // 3 - 1 = 2
        HeroNode cur = head.next;
        for(int i =0; i< size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //将单链表反转 [腾讯面试题]
    public void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null) {
            return ;
        }

        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;// 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        //动脑筋
        while(cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }

    //可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    //[百度面试题]
    public  void reversePrint(HeroNode head) {
        if(head.next == null) {
            return;//空链表，不能打印
        }
        //创建要给一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while(cur != null) {
            stack.push(cur);
            cur = cur.next; //cur后移，这样就可以压入下一个节点
        }
        //将栈中的节点进行打印,pop 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop()); //stack的特点是先进后出
        }
    }


}
