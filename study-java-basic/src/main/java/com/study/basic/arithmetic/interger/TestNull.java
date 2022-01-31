package com.study.basic.arithmetic.interger;

import lombok.Data;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-08-11 18:03
 *@describe:
 *@version:
 */

public class TestNull {


    public static void main(String[] args) {
        if ( new Testshuju().getType() == null){
            System.out.println("===========");
        }
    }


}

@Data
class Testshuju{
    private Integer type;
}
