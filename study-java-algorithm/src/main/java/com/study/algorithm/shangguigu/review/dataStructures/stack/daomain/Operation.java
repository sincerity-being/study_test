package com.study.algorithm.shangguigu.review.dataStructures.stack.daomain;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-14 09:01
 * @describe 编写一个类 Operation 可以返回一个运算符 对应的优先级
 */
public class Operation {


    private static int ADDITION=1;
    private static int SUBTRACTION=1;
    private static int MULTIPLICATION=2;
    private static int DIVISION=2;

    public static int getValue(String operation){
        int result;
        switch (operation){
            case "+":
                result=ADDITION;
                break;
            case "-":
                result=SUBTRACTION;
                break;
            case "*":
                result=MULTIPLICATION;
                break;
            case "/":
                result=DIVISION;
                break;
            default:
//                System.out.println("不存在该运算符");
                result=0;
        }
        return result;
    }
}
