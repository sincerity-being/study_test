package com.study.basic.easyCoding.chapcter02;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-27 18:43
 * @describe
 */
public class StaticCode {
    static String prior = "done";
    // 依次调用 f() 的结果, 三目运算符为true 执行g() 最后赋值成功
    static String last = f() ? g() : prior;

    public static boolean f(){
        return true;
    }

    public static String g(){
        return  "hello world";
    }

    static {
        // 静态代码块 可以访问 静态变量和静态方法
        System.out.println(last);
        g();
    }


}
