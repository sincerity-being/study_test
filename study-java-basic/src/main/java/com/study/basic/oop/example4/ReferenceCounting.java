package com.study.basic.oop.example4;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-13 15:37
 * @describe
 */
public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {
                new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared),
                new Composing(shared)
        };
        for (Composing c : composing){
            c.dispose();
        }
    }
}
