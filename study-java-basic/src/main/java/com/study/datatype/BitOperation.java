package com.study.datatype;

/***
 *
 *https://blog.csdn.net/qiluzhai097/article/details/18220031
 *@ author: HeYQ
 *@ date: 2020-09-09 09:33
 *@ describe:
 *@ version:
 */
public class BitOperation {

    public static void main(String[] args) {
        exchangeFunction1();
        exchangeFunction2();
    }

    private static void exchangeFunction1() {
        int a = 1;
        int b = 2;
        System.out.println("交换前 a=="+ a);
        System.out.println("交换前 b==" + b);
        //先定义一个中间变量
        int c ;
        //  然后开始交换：
        c = a;
        a = b;
        b = c;
        System.out.println("交换后 a=="+ a);
        System.out.println("交换后 b==" + b);
    }

    //第二种方法就是不用定义中间变量就能完成交换功能的方法：
    private static void exchangeFunction2() {
        int a = 1;
        int b = 2;
        System.out.println("交换前 a=="+ a);
        System.out.println("交换前 b==" + b);
        a = a + b;
        b = a - b; // 此时的a已经不是原来的a 了，此时 a = a + b;
        a = a - b; //此时的a和b都不是原来的a和b了，此时的 a 是原来两个变量的和，此时的 b 是原来的变量a 的值。
        System.out.println("交换后 a=="+ a);
        System.out.println("交换后 b==" + b);
    }


    /***
     * 这种方法比较有技巧性（本方法采用的是位运算中的技巧：a = a ^ b ^ b，
     * 也就是一个数连续与另一个数进行两次与运算结果还是这个数本身）：
     */
    private static void exchangeFunction3() {
        int a = 1;
        int b = 2;
        System.out.println("交换前 a=="+ a);
        System.out.println("交换前 b==" + b);
        a =  a ^ b;
//此时的a已经不是原来的a了，此时右边的表达式就等价于：( a ^ b ) ^ b ，结果是a，并把它赋予变量b；
        b =  a ^ b;
//此时的a与b都不是原来的a与b了，此时右边的表达式就等价于：a ^ ( a ^ b ) ，结果是b，并把它赋予变量a；
        a =  a ^ b;
        System.out.println("交换后 a=="+ a);
        System.out.println("交换后 b==" + b);
    }

}
