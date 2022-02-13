package com.study.designpattern.bookjanpan.visitor.data;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-03 14:12
 * @describe
 */
public class FileTreatmentException extends RuntimeException {

    public FileTreatmentException(){

    }
    public FileTreatmentException(String msg){
        super(msg);
    }

}
