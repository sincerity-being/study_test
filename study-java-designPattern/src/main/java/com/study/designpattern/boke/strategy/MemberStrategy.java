package com.study.designpattern.boke.strategy;

/***
 *
 *@ author: HeYQ
 *@ date: 2020-10-22 16:46
 *@ version: 1.0
 *@ describe:
 *
 */
public interface MemberStrategy {

    /**
    *计算图书的价格
    *@ author: HeYQ
    *@ date: 2020/10/22 16:47
    *@ param booksPrice    图书的原价
    *@ return 计算出打折后的价格
    *@ vision:
    */
    public double calcPrice(double booksPrice);


}
