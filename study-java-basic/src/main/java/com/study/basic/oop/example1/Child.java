package com.study.basic.oop.example1;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


/**
 * https://www.cnblogs.com/chenssy/p/3372798.html
 * java的多态
 * 方法 编译看左边 运行看右边(重载)
 *  向上转时，变量类型定义了它所能调用的成员变量和方法，变量是类型自己的，但是方法假如重写了，那调用的是重写后的方法
 *  https://blog.csdn.net/qq_36746928/article/details/111186114
 *      --变量看类型(左边)，方法看右边()
 * <p>  </p>
 *
 * @author 何裕墙  heyuqiang@kungeek.com
 * @since 1.0
 */
public class Child  extends Parent {
    private int a = 2;

    @Override
    public void fun(){
        System.out.println("c--------------");
    }
    public static void main(String[] args) {
//        Parent p = new Child();
//        p.fun();
//        System.out.println(p.a);
        new Child();
        new ChildT();
    }
}
