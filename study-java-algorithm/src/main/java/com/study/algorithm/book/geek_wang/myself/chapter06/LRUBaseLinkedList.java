package com.study.algorithm.book.geek_wang.myself.chapter06;

import com.study.algorithm.book.geek_wang.object.SNode;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-03 11:33
 * @describe
 *
 * 首先先定义好 LRUBaseLinkedList 的属性
 */
public class LRUBaseLinkedList<T> {

    /**
     * 默认容量
     */
    private  final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头节点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
        this.headNode = new SNode<>();
    }

    public LRUBaseLinkedList(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.headNode = new SNode<>();
    }

    /**
     * 找到前面一个元素
     * @param data
     * @return
     */
    private SNode<T> findPre(T data) {
        SNode<T> node = headNode;
        while (node.getNext() != null){
            if (data.equals(node.getNext().getElement())){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 往链表头插入前一个节点.
     * @param data
     */
    private void insertElemAtBegin(T data) {
        SNode<T> next = headNode.getNext();
        headNode.setNext(new SNode<>(data, next));
        length++;
    }

    /**
     * 删除最后一个元素节点
     */
    private void deleteElemAtEnd() {
        SNode<T> ptr = headNode;
        if (ptr.getNext() == null){
            return;
        }
        /**
         * 找到导数第二个节点
         */
        while(ptr.getNext().getNext() != null){
            ptr = ptr.getNext();
        }
//        SNode<T> tmp = ptr.getNext();
        ptr.setNext(null);
        length--;
    }

    private void deleteElemPre(SNode<T> preNode) {
        SNode<T> temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        length--;
    }
    private void printAll() {
        SNode<T> node = headNode.getNext();
        while(node != null){
            System.out.println(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    /**
     * lru 核心 代码
     * (1) 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，
     *   然后再插入到链表的头部。
     *
     * (2) 如果此数据没有在缓存链表中，又可以分为两种情况:
     *    1) 如果此时缓存未满，则将此结点直接插入到链表的头部；
     *    2) 如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
     *
     * @param data
     */
    public void add(T data){
        // 1) 找到 链表中 data 前一个节点
        SNode<T> pre = findPre(data);

        if (pre != null){
            deleteElemPre(pre);
            insertElemAtBegin(data);
        }else {
            if (length >= this.capacity) {
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }



}
