package com.study.basic.oop.example3;


import static com.study.basic.util.Print.print;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-13 14:37
 * @describe
 */
public class Sandwich extends PortableLunch{
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();
    public Sandwich(){
        print("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}
