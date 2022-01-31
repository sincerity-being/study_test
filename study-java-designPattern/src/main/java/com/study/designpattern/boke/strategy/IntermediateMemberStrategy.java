package com.study.designpattern.boke.strategy;

/***
 *
 *@ author: HeYQ
 *@ date: 2020-10-22 16:49
 *@ version: 1.0
 *@ describe:　中级会员折扣类
 */
public class IntermediateMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
    }
}
