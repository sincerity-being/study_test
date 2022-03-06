package com.study.basic.oop.example10;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 21:32
 * @describe
 */
public class Parcel11 {

    private static class ParcelContents{
        private int i =11;
        public int value(){
            return i;
        }
    }
    public static  ParcelContents parcelContents(){
        return new ParcelContents();
    }
}
