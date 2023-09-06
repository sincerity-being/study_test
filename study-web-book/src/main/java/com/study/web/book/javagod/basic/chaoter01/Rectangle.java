package com.study.web.book.javagod.basic.chaoter01;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-05-17 20:12
 * @describe 矩形
 */
class Rectangle {

    /**
     * 设置矩形的长度和宽度
     */
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    /**
     * 长度
     */
    private int length;

    /**
     * 宽度
     */
    private int width;

    /**
     * 获得矩形面积
     *
     * @return
     */
    public int area() {
        return this.length * this.width;
    }
}

