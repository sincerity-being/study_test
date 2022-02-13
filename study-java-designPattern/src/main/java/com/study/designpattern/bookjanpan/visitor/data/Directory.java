package com.study.designpattern.bookjanpan.visitor.data;

import com.study.designpattern.bookjanpan.visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-03 14:17
 * @describe
 */
public class Directory extends Entry{

    //文件夹名字
    private String name;

    // 目录条目集合
    private ArrayList<Entry> dir = new ArrayList<>(10);

    public Directory(String name){
        this.name = name;
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
        int size = 0;
        for (Entry entry : dir) {
            size += entry.getSize();
        }
        return size;
    }
}
