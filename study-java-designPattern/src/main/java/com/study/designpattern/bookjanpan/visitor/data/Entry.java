package com.study.designpattern.bookjanpan.visitor.data;

import java.util.Iterator;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-03 14:07
 * @describe 扩展Element类
 */
public abstract class Entry implements Element {

    // 获取名字
    public abstract String getName();

    // 获取大小
    public  abstract int getSize();

    //增加目录条目
    public Entry add() throws FileTreatmentException{
        throw new FileTreatmentException();
    }

    // 生成iterator
    public Iterator<Entry> iterator() throws FileTreatmentException{
        throw new FileTreatmentException();
    }

    // 显示字符串
    public String toString(){
        return getName() + "(" + getSize() + ")";
    }
}
