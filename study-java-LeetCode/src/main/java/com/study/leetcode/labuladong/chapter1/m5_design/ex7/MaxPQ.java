package com.study.leetcode.labuladong.chapter1.m5_design.ex7;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2023-08-22 15:26
 * @describe
 */
public class MaxPQ
        <Key extends Comparable<Key>> {

    /**
     *     // 存储元素的数组
     *     关键点: 1) 不同于链表元素之间没有link
     *            2)只能通过地址进行访问!
     *            3) 最大堆的堆顶就是最大元素 --> 特点
     */
    private Key[] pq;
    // 当前 Priority Queue 中的元素个数
    private int size = 0;

    public MaxPQ(int cap) {
        // 索引 0 不用，所以多分配一个空间
        pq = (Key[]) new Comparable[cap + 1];
    }

    /* 返回当前队列中最大元素 */
    public Key max() {
        return pq[1];
    }

    /* 插入元素 e   */
    public void insert(Key e) {
        size ++;
        pq[size] = e;
        swim(size);

    }

    /* 删除并返回当前队列中最大元素 */
    public Key delMax() {
        Key max = pq[1];
        swap(1, size);
        pq[size] = null;
        size--;
        sink(1);
        return max;
    }

    /* 上浮第 x 个元素，以维护最大堆性质 */
    private void swim(int x) {

        while(x > 1 && less(parent(x), x)){
            swap(parent(x), x);
            x = parent(x);
        }

    }

    /* 下沉第 x 个元素，以维护最大堆性质 */
    private void sink(int x) {
        while(left(x) <= size){
            int max = left(x);
            if (right(x) <= size && less(max, right(x))){
                max = right(x);
            }
            if (less(max, x)){
                break;
            }
            swap(max, x);
            x = max;

        }

    }

    /* 交换数组的两个元素 */
    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /* pq[i] 是否比 pq[j] 小？ */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /* 还有 left, right, parent 三个方法 */
    // 父节点的索引
    int parent(int root) {
        return root / 2;
    }
    // 左孩子的索引
    int left(int root) {
        return root * 2;
    }
    // 右孩子的索引
    int right(int root) {
        return root * 2 + 1;
    }

}

