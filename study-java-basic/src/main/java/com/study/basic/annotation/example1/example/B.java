package com.study.basic.annotation.example1.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-11 20:05
 * @describe  https://blog.csdn.net/u014750606/article/details/79977114
 */

public class B implements A {

    @Override
    public String func1() {
        //do something ...
        return null;
    }

    public String func2() {
        //do something ...
        return null;
    }

    public static void main(String[] args) {
        B bInstance = new B();
        B bProxy = (B) Proxy.newProxyInstance(
                // B 类的类加载器
                B.class.getClassLoader(),
                // B 类所实现的接口，
                // 如果你想拦截B类的某个方法，必须让这个方法在某个接口中声明并让B类实现该接口
                B.class.getInterfaces(),
                // 调用处理器，任何对 B类所实现的接口方法的调用都会触发此处理器
                new InvocationHandler(){
                    @Override
                    public Object invoke(
                            // 这个是代理的实例，method.invoke时不能使用这个，否则会死循环
                            Object proxy,
                            // 触发的接口方法
                            Method method,
                            // 此次调用该方法的参数
                            Object[] args) throws Throwable {
                        System.out.println(String.format("调用 %s 之前", method.getName()));
                        /**
                         * 这里必须使用B类的某个具体实现类的实例，因为触发时这里的method只是一个接口方法的引用，
                         * 也就是说它是空的，你需要为它指定具有逻辑的上下文(bInstance)。
                         */
                        Object obj = method.invoke(bInstance, args);
                        System.out.println(String.format("调用 %s 之后", method.getName()));
                        //返回调用结果
                        return obj;
                    }

                });

    }
}
