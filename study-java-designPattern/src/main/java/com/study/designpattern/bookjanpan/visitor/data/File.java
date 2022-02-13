package com.study.designpattern.bookjanpan.visitor.data;

import com.study.designpattern.bookjanpan.visitor.Visitor;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-03 14:15
 * @describe
 */
public class File  extends Entry{

    private String name;

    private int size;

    public File(String name, int size){
        this.name = name;
        this.size = size;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }
}
