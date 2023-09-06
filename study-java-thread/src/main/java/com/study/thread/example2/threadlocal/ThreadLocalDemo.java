package com.study.thread.example2.threadlocal;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-05-06 23:20
 * @describe
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> localVar = new ThreadLocal<String>();

    private static ThreadLocal<String> localVar2 = new ThreadLocal<String>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
      //  localVar.remove();
    }
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            public void run() {
                ThreadLocalDemo.localVar.set("local_A");
                print("A");
                //打印本地变量
               // System.out.println("after remove : " + localVar.get());

            }
        },"A").start();

        Thread.sleep(1000);

        new Thread(new Runnable() {
            public void run() {
                ThreadLocalDemo.localVar.set("local_B");
                print("B");
                System.out.println("after remove : " + localVar.get());

            }
        },"B").start();
    }
}


