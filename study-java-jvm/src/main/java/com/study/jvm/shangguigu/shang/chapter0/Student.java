package com.study.jvm.shangguigu.shang.chapter0;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-06-04 11:06
 * @describe java⽗类对象和⼦类对象的互相转换
 * 链接：https://wenku.baidu.com/view/aa0c147774232f60ddccda38376baf1ffc4fe3dd.html
 */
public class Student extends Person{

    public static void main(String[] args) {
        Student student ;
        Person person = new Student();
        person.setName("1111111");
        student = (Student) person;
        System.out.println(student.getName());
        person.setName("222");
        System.out.println(student.getName());
    }




}
