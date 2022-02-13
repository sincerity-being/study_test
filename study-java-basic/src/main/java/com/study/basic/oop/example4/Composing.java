package com.study.basic.oop.example4;

import static com.study.basic.util.Print.print;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-13 15:33
 * @describe
 */
public class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;
    public Composing(Shared shared){
        print("Creating" + this);
        this.shared =shared;
        this.shared.addRef();
    }

    protected void dispose(){
        print("Disposing" + this);
        shared.dispose();
    }

    public String toString(){
        return "Composing " + id;
    }



}
