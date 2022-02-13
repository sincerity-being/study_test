package com.study.basic.enumtest.example1;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-01-31 22:49
 * @describe 编译器为enum 自动生成某些 方法
 * toString() ordinal() values()
 *
 * enum 可以看出一个特殊的类
 */
public class EnumDemo {
    public static void main(String[] args) {
        for(Spiciness s : Spiciness.values()){
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }
}
