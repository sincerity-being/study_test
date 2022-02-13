package com.study.basic.oop.example4;

import static com.study.basic.util.Print.print;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-13 15:28
 * @describe thinking in java 第8章
 */
public class Shared {
    private int refcount = 0;
    private static  long counter  = 0;
    private final long id = counter++;
    public Shared(){
        print("Creating" + this);
    }

    public void addRef(){
        refcount ++;
    }

    protected void dispose(){
        if(--refcount == 0){
            print("Disposing" + this);
        }
    }

    public String toString(){
        return "Shared " + id;
    }


}
