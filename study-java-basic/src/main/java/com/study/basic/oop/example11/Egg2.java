package com.study.basic.oop.example11;

import static com.study.basic.util.Print.print;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 22:40
 * @describe
 */
public class Egg2 {

    protected class Yolk{
        public Yolk(){
            print("Egg2.Yolk()");
        }
        public void f(){
            print("Egg2.Yolk.f()");
        }
    }
    public Egg2(){
        print("Egg2");
    }

    public static void main(String[] args) {
        new Egg2();
    }

}
