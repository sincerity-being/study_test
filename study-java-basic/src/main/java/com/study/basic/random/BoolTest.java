package com.study.basic.random;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import java.util.Random;

/**
 * 注释..
 * <p>  </p>
 *
 * @author 何裕墙  heyuqiang@kungeek.com
 * @since 1.0
 */
public class BoolTest {



    public static void main(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt(100);
        int j = rand.nextInt(100);
        System.out.println("i= " + i);
        System.out.println("j= " + j);

        Random random = new Random();
        int a = random.nextInt(2);
        System.out.println("a=="+a);
        if(a==0){
            System.out.println("反面");
        }else{
            System.out.println("正面");
        }

        //方法二，随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
        double b=Math.random();
        System.out.println("b=="+b);
        if(b<0.5){
            System.out.println("反面");
        }else{
            System.out.println("正面");
        }

    }



}
