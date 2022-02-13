package com.study.designpattern.bookjanpan.visitor;


import com.study.designpattern.bookjanpan.visitor.data.Directory;
import com.study.designpattern.bookjanpan.visitor.data.Entry;
import com.study.designpattern.bookjanpan.visitor.data.File;

/**
 *访问者
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-03 13:57
 * @describe
 */
public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
   // public abstract void visit(Entry entry);
}
