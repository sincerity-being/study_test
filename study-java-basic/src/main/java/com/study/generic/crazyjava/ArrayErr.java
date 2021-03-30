package com.study.generic.crazyjava;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-28 17:13
 * @describe 疯狂讲义第九章 9.3 ArrayErr
 * 数组和泛型有所不同. 假设Foo 是Bar 的一个子类型(子类或者子接口),
 * 那么Foo[] 依然是Bar[]的子类型; 但G<Foo> 不是G<Bar> 的子类型.
 *
 * null 是所有引用类型的实例.
 * 当直接使用List<?> 这种形式时, 即表明这个List集合可以是任何泛型List的父类
 * java 不允许将对象放进一个位置类型的集合中.
 */
public class ArrayErr {
    public static void main(String[] args){
        //定义一个Integer数组 数值是协变 遵循 编译看左边 运行看右边的多态原则
        Integer[] ia = new Integer[5];
        //可以把一个Integer[] 数组赋给 Number[] 变量
        Number[] na = ia;
       // na[0] = 0.5;
// java.lang.ArrayStoreException: java.lang.Double
        System.out.println(ia);


        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new Integer(111));
        a1.add(new String("hello a1a1"));

        List<Integer> a3 = a1;
        a3.add(new Integer(133));
        System.out.println(a1);
        System.out.println(a3);



    }


}
