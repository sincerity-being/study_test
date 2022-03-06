package com.study.basic.oop.example10;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 22:20
 * @describe
 */
public class InheritInner extends WithInner.Inner {
    InheritInner(WithInner wi){
        wi.super();
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        InheritInner ii = new InheritInner(withInner);
    }
}
