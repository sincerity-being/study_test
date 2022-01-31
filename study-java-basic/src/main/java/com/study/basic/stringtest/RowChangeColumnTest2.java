package com.study.basic.stringtest;



import java.io.*;
import java.util.Scanner;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-01-05 14:09
 * @describe  java 去除字符串中多余的空格，只留一个  https://blog.csdn.net/hongmin118/article/details/78263150
 *StringBuffer sb=new StringBuffer();//用其他方法实现
 * 		int flag;
 * 		for(int i=0;i<string.length();i++){
 * 			flag=0;
 * 			if(string.charAt(i)!=' '){
 * 				sb.append(string.charAt(i));
 *                        }else{
 * 				flag=1;
 *            }
 * 			try {
 * 				if(string.charAt(i)==' '&&string.charAt(i+1)!=' '){
 * 					sb.append(' ');
 *                }
 *            } catch (Exception e) {
 * 				continue;
 *            }        * 		}
 * 		System.out.println(sb);
 *
 *NotePad++ 怎么把一列/数行 数据转成一行
 *https://zhidao.baidu.com/question/1513386820428441740.html
 *利用notepad++正则表达式将 多个空格 替换为一个逗号
 *https://blog.csdn.net/songchunmin_/article/details/105670586
 */
public class RowChangeColumnTest2 {


    public static void main(String[] args) throws IOException {
        System.out.println("请输入要转换的文件路径source src:");
        Scanner scanner = new Scanner(System.in);
        String sourceSrc =  scanner.next();
        File srcFile = new File(sourceSrc);
        File destFile = new File("./1.txt");
        if (!destFile.exists()){
            boolean newFile = destFile.createNewFile();
            System.out.println(newFile);
            if (!newFile){
                return;
            }
        }
        StringBuilder result = new StringBuilder();
        try (Reader r = new FileReader(srcFile)) {
            int i;
            while ((i = r.read()) != -1) {
                char c = (char) i;
                if (c == '\r' || c == '\n') {
                    c = ' ';
                }
                result.append(c);
            }
        }
        System.out.println("result" + result);
        String original = result.toString();
        System.out.println("original:" + original);

        StringBuilder sb = new StringBuilder();
        //标记是否是第一个空格
        boolean isFirstSpace = false;
        //如果考虑开头和结尾有空格的情形
        original = original.trim();
        char c;
        for(int j = 0; j < original.length(); j++){
            c = original.charAt(j);
            //遇到空格字符时,先判断是不是第一个空格字符
            if(c == ' ' || c == '\t') {
                if(!isFirstSpace) {
                    sb.append(c);
                    isFirstSpace = true;
                }
            } else{
                //遇到非空格字符时
                sb.append(c);
                isFirstSpace = false;
            }
        }
        System.out.println("sb=" + sb.toString());
        Writer writer = null;
       try{
          writer = new FileWriter(destFile);
          writer.write(sb.toString());
       }finally{
          // 写完要进行关闭 否则 会导致没有内容
           assert writer != null;
           writer.close();
      }

    }
}
