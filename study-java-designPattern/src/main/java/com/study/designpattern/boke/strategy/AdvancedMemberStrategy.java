package com.study.designpattern.boke.strategy;

/***
 *
 *@ author: HeYQ
 *@ date: 2020-10-22 16:50
 *@ version: 1.0
 *@ describe:高级会员折扣类
 *
 */
public class AdvancedMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
    }
}
