package com.study.algorithm.shangguigu.review.dataStructures.stack.poland;

import com.study.algorithm.shangguigu.review.dataStructures.stack.daomain.ReversePolishCal;
import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-14 11:53
 * @describe 已经给出的是后缀表达式 进行计算
 */
public class PolandNotation {


    public static void main(String[] args) {


		//先定义给逆波兰表达式
		//(30+4)×5-6  => 30 4 + 5 × 6 - => 164
		// 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +
		//测试
		//说明为了方便，逆波兰表达式 的数字和符号使用空格隔开
		//String suffixExpression = "30 4 + 5 * 6 -";
		String suffixExpression = "4 5 * 8 - 60 + 8 2 / +"; // 76
		//思路
		//1. 先将 "3 4 + 5 × 6 - " => 放到ArrayList中
		//2. 将 ArrayList 传递给一个方法，遍历 ArrayList 配合栈 完成计算
        ReversePolishCal reversePolishCal = new ReversePolishCal();
		List<String> list =  reversePolishCal.getListString(suffixExpression);
		System.out.println("rpnList=" + list);
		int res = reversePolishCal.calculate(list);
		System.out.println("计算的结果是=" + res);
    }

}
