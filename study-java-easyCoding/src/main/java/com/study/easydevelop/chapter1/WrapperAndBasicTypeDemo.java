package com.study.easydevelop.chapter1;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-01-21 11:29
 * @describe
 * 自动拆箱
 *   1) 表达式1 或 表达式2 的值只要有一个原始类型 (到多个Integer 相乘的结果是int 的
 * 问题)
 *   2)表达式1或表达式2的值得类型不一致,会强制拆箱升级成表示范围更大的那个类型.
 *
 *
 */
public class WrapperAndBasicTypeDemo {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Boolean flag = false;
        // a*b的结果是int类型,那么c会强制拆箱成int类型, 抛出NPE异常
        Integer result = (flag ? a*b : c);

    }


}
