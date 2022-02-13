package com.study.designpattern.bookjanpan.visitor.data;

import com.study.designpattern.bookjanpan.visitor.Visitor;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-03 14:06
 * @describe
 */
public interface Element {
    public abstract void accept(Visitor v);
}
