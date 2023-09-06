package com.study.jvm.shangguigu.shang.chapter13;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-06-03 14:49
 * @describe
 */
public class StringTest {

    public static void main(String[] args) {

        String s = "1".toString();

        String s1 = null;
        for (int i = 0; i < 10; i++) {
            s1 += "i";
        }
    }

    public void test(){
        String s = new String("a");

        String s0 = s.intern();
        String s1 = "a";
        System.out.println(s == s1);
        System.out.println(s0 == s1);
        System.out.println(s0 == s);
        System.out.println(s.hashCode() + " " + s1.hashCode() + " " + s0.hashCode());
    }
}
