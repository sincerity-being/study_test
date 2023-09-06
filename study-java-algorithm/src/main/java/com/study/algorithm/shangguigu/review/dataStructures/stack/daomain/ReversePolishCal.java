package com.study.algorithm.shangguigu.review.dataStructures.stack.daomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-03-14 11:50
 * @describe 将中缀表达式转换成前缀表达式的操作类
 */
public class ReversePolishCal {


    //将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList中
    public  List<String> getListString(String suffixExpression) {
        //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele: split) {
            list.add(ele);
        }
        return list;
    }


    /**
     * 把字符串转换成中序表达式 : 比如 2+(3-4), 并放入到List中
     * @param infixExpression
     * @return
     */
    public List<String> toInfixExpression(String infixExpression) {
        List<String> ls = new ArrayList<String>();//存储中序表达式
        int i = 0;
        String str;
        char c;
        do {
            //如果c 在 < 48 或者 > 57 说明是符号, 这里没有判断是 + , - , * , / 等等
            if ((c = infixExpression.charAt(i)) < 48 || (c = infixExpression.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else { // 说明是数字，要进行拼接处理
                str = "";
                while (i < infixExpression.length() && (c = infixExpression.charAt(i)) >= 48
                        && (c = infixExpression.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }

        } while (i < infixExpression.length());
        return ls;
    }

    /**
     * 将一个中缀表达式对应的List 转成 转换成逆波兰表达式, 放入到List中
     * @param ls
     * @return
     */
    public  List<String> parseSuffixExpression(List<String> ls) {
        Stack<String> s1=new Stack<String>();
        //说明：因为s2 这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
        //因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2
        //Stack<String> s2 = new Stack<String>(); // 储存中间结果的栈s2
        List<String> lss = new ArrayList<String>();
        for (String ss : ls) {
            if (ss.matches("\\d+")) {
                lss.add(ss);
            } else if (ss.equals("(")) {
                s1.push(ss);
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
            } else if (ss.equals(")")) {
                while (!s1.peek().equals("(")) {
                    lss.add(s1.pop());
                }
                //!!! 将 ( 弹出 s1栈， 消除小括号
                s1.pop();
            } else {
                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(ss)) {
                    lss.add(s1.pop());
                }
                s1.push(ss);
            }
        }
        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            lss.add(s1.pop());
        }
        //注意因为是存放到List, 因此按顺序输出就是对应的后缀表达式对应的List
        return lss;
    }

	/*
	  完成对逆波兰表达式的运算
	 * 1)从左至右扫描，将3和4压入堆栈；
		2)遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
		3)将5入栈；
		4)接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
		5)将6入栈；
		6)最后是-运算符，计算出35-6的值，即29，由此得出最终结果
		*  @param ls 是一个按照逆波兰表达式得到衣蛾List
     * @return
     */
    public int calculate(List<String> ls) {
        Stack<String> s=new Stack<String>();
        for (String str : ls) {
            if (str.matches("\\d+")) {
                s.push(str);
            } else {
                int b = Integer.parseInt(s.pop());
                int a = Integer.parseInt(s.pop());
                int result=0;
                if (str.equals("+")) {
                    result = a + b;
                } else if (str.equals("-")) {
                    result = a - b;
                } else if (str.equals("*")) {
                    result = a * b;
                } else if (str.equals("/")) {
                    result = a / b;
                } else {
                    throw new RuntimeException("符号错误");
                }
                s.push("" + result);
            }
        }
        //System.out.println(s.peek());
        return Integer.parseInt(s.pop());
    }





}
