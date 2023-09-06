package com.study.algorithm.shangguigu.review.dataStructures.tree;

import com.study.algorithm.shangguigu.review.dataStructures.tree.domain.HeroNode;
import com.study.algorithm.shangguigu.review.dataStructures.tree.domain.ThreadedBinaryTree;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-08 20:01
 * @describe  线索二叉树
 */
public class ThreadedBinaryTreeDemo {


    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);


        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        //3
        System.out.println("10号结点的前驱结点是 ="  + leftNode);
        //1
        System.out.println("10号结点的后继结点是="  + rightNode);




    }




}
