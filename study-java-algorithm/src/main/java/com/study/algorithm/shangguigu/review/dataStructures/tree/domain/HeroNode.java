package com.study.algorithm.shangguigu.review.dataStructures.tree.domain;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-08 20:03
 * @describe
 */
public class HeroNode {
    private int no;

    private String name;

    // 默认null;
    private HeroNode left;

    private HeroNode right;

    /**
     * 说明
     * 	1. 如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
     * 2. 如果rightType == 0 表示指向是右子树, 如果 1表示指向后继结点
     */
    private int leftType;

    private int rightType;


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }


    /**
     * 普通树三种遍树的方法
     *
     */
 // 前序
    public void preOrder(){
        // 先输出父节点
        System.out.println(this);

        if(this.left != null){
            this.left.preOrder();
        }

        if (this.right != null){
            this.right.preOrder();
        }

    }

    //中序遍历
    public void infixOrder() {

        //递归向左子树中序遍历
        if(this.left != null) {
            this.left.infixOrder();
        }
        //输出父结点
        System.out.println(this);
        //递归向右子树中序遍历
        if(this.right != null) {
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder() {
        if(this.left != null) {
            this.left.postOrder();
        }
        if(this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }






}
