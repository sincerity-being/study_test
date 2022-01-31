package com.study.designpattern.boke.strategy;

/***
 *
 *@ author: HeYQ
 *@ date: 2020-10-22 16:48
 *@ version: 1.0
 *@ describe:初级会员折扣类
 *
 */
public class PrimaryMemberStrategy implements  MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("对于初级会员的没有折扣");
        return booksPrice;
    }

}
