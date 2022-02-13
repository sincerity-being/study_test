package com.study.basic.packtest.example1;

import com.study.basic.packtest.example1.dessert.Cookie;

/**
 * https://www.cnblogs.com/liu2687479342/p/14691339.html
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-03 12:07
 * @describe
 */
public class ChocolateChip  extends Cookie {

    private static  String str;

    public ChocolateChip(){
        System.out.println("ChocolateChip constructor");
    }
    public void chomp(){
        bite1();
    }

    public static void main(String[] args) {
        ChocolateChip x = new ChocolateChip();
        x.chomp();
        System.out.println(str);
    }


}
