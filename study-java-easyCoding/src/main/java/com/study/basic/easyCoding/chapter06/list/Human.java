package com.study.basic.easyCoding.chapter06.list;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import java.util.ArrayList;
import java.util.List;

/**
 *Java对象类型向上转型和向下转型
 * https://blog.csdn.net/yuncaidaishu/article/details/88690799
 * <p>  </p>
 *
 * @author 何裕墙  heyuqiang@kungeek.com
 * @since 1.0
 */
public class Human extends Man{

    @Override
    public void show() {
        System.out.println("this is a human");
    }
    public void test() {
        System.out.println("i am a human");
    }

    public static void main(String[] args) {
      //  Human human = (Human) new Man();
        // 运行时报错
      //  human.test();
      //  human.show();
        Man man = new Human();
        Human human = (Human) man;
        human.show();

        List<Human> list1 = new ArrayList<>(10);
        List<? extends Man> list = new ArrayList<>(10);
        list = list1;
        list.add(null);
    }
}
