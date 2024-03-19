package com.study.algorithm.book.geek_wang.object;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2024-03-03 11:05
 * @describe
 */
public class SNode<T>{

    private T element;

    private SNode<T> next;

    public SNode(T element, SNode<T> next) {
        this.element = element;
        this.next = next;
    }

    public SNode() {
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public SNode<T> getNext() {
        return next;
    }

    public void setNext(SNode<T> next) {
        this.next = next;
    }
}
