package com.study.algorithm.shangguigu.review.dataStructures.linkedlist.domain;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-14 09:25
 * @describe 定义HeroNode ， 每个HeroNode 对象就是一个节点
 */
public class HeroNode {

    public int no;
    public String name;
    public String nickname;

    //指向下一个节点
    public HeroNode next;
    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
        this.next = null;
    }
    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
