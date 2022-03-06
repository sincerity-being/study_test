package com.study.basic.oop.example10;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-14 20:59
 * @describe 一个定义在方法中的类 thinking in java 第10章
 */
public class parcel6 {

    private void internalTracking(boolean b){
        if(b){
            class TrackingSlip{
                private String id;
                TrackingSlip(String s){
                    id = s;
                }

                public String getId() {
                    return id;
                }
            }

            TrackingSlip ts = new TrackingSlip("x");
            String id = ts.getId();
        }
    }


    public void track(){
        internalTracking(true);
    }

    public static void main(String[] args) {
        parcel6 parcel6 = new parcel6();
        parcel6.track();
    }

}
