package com.study.algorithm.shangguigu.review.dataStructures.stack.poland;


import com.study.algorithm.shangguigu.review.dataStructures.stack.daomain.ReversePolishCal;
import java.util.List;


/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-14 11:40
 * @describe 实现中缀表达式转为后缀表达式 并计算
 */
public class ReversePolishCalCase {


    public static void main(String[] args) {
        test2();
    }


    private static void test2(){
        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)×4)-5 => 转成  1 2 3 + 4 × + 5 –
        //2. 因为直接对str 进行操作，不方便，因此 先将  "1+((2+3)×4)-5" =》 中缀的表达式对应的List
        //   即 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
        //   即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]
        String expression = "1+((2+3)*4)-5";//注意表达式

        ReversePolishCal reversePolishCal = new ReversePolishCal();
        List<String> infixExpressionList = reversePolishCal.toInfixExpression(expression);
        System.out.println("中缀表达式对应的List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> suffixExpreesionList = reversePolishCal.parseSuffixExpression(infixExpressionList);
        System.out.println("后缀表达式对应的List" + suffixExpreesionList); //ArrayList [1,2,3,+,4,*,+,5,–]

        System.out.printf("expression=%d", reversePolishCal.calculate(suffixExpreesionList)); // ?
    }


    private static void test1() {
        //举例1: 2 + (3-4) => 2 3 4 - +
        //举例2: 4 * 5 - 8 + 60 + 8 / 2 = 4 5 * 8 - 60 + 8 2 / +
        //举例3: (3+4)×5-6 => 3 4 + 5 * 6 -
        //String suffixExperss = "4 5 * 8 - 60 + 8 2 / +";
        //String suffixExperss = "2 3 4 - +";
//		String suffixExperss = "3 4 + 5 * 6 -";
//
        ReversePolishCal reversePolishCal = new ReversePolishCal();
//
//		List <String> suffixExpressionList = reversePolishCal.getListBySuffixExpression(suffixExperss);
//
//        System.out.println("计算结果:"+ reversePolishCal.calculate(suffixExpressionList));

        //测试输入中缀表达式是否能计算成功
        String infixExpression = "4*5-8+60+8/2";


        List<String> infixExpressionList = reversePolishCal.toInfixExpression(infixExpression);
        List<String> suffixExpressionList2 = reversePolishCal.parseSuffixExpression(infixExpressionList);
        //输出后缀表达式
        for(String ele : suffixExpressionList2) {
            System.out.print(ele + " ");
        }
        System.out.println();
        //输出结果
        System.out.println("计算结果:"+ reversePolishCal.calculate(suffixExpressionList2));
    }

}




