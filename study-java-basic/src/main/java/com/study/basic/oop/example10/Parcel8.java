package com.study.basic.oop.example10;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 21:11
 * @describe
 */
public class Parcel8 {
    public Wrapping wrapping(int x){

        return new Wrapping(x){
          public int value(){
              return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping w = parcel8.wrapping(10);
        System.out.println(w.value());
    }
}
