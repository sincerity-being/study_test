package com.study.algorithm.book.geek_wang.myself.chapter08;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2023-09-07 19:14
 * @describe
 */
public class ArrayStack {
    private String[] items;
    private int count;
    private int n;

    public ArrayStack(int n){
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }


    public boolean push(String item){
        if (count == n) {
            return false;
        }
        items[count] = item;
        ++ count;
        return true;
    }

    public String pop(){
        if (count == 0){
            return null;
        }
        String tmp = items[count - 1];
        -- count;
        return tmp;
    }






}
