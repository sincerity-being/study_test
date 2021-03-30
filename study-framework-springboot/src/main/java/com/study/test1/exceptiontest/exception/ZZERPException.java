package com.study.test1.exceptiontest.exception;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-08-05 17:36
 *@describe:
 *@version:
 */
public class ZZERPException extends Exception {
     private Integer errorCode;
     private String message;


     public ZZERPException(String message){
         super(message);
         this.message = message;
     }

     public ZZERPException(Integer errorCode, String message){
         super(message);
         this.errorCode = errorCode;
         this.message = message;
     }

}
