package com.study.basic.stringtest;

import java.io.*;
import java.util.Scanner;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-01-05 14:09
 * @describe
 */
public class RowChangeColumnTest {


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
        InputStream is = new FileInputStream(srcFile);
        OutputStream out = new FileOutputStream(destFile);
        StringBuilder result = new StringBuilder();
       //构造一个BufferedReader类来读取文件
       /* BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String s = null;
        //使用readLine方法，一次读一行
        while((s = br.readLine())!=null){
            result.append( System.lineSeparator() + s);
        }
        br.close();*/
        Reader r = new FileReader(srcFile);
        int i ;
        while((i= r.read()) != -1){
            char c = (char) i;
            if ( c == '\r' || c == '\n'){
                c = ' ';
            }

            result.append(c);
        }
        System.out.println("result" + result);

        String input = result.toString();

        String tmp="";
        StringBuilder output = new StringBuilder();
        for(int j = 0; j < input.length(); j++) {
            //遍历字符串,连续" "多个时,replace掉,最后转置
            if(input.charAt(j)==' ' && input.charAt(j) + 1 !=' ') {
                //只有一个' '时
                //不操作
            }else {
                tmp = input.replaceAll("[' ']+"," ");
                //正则表达式,超过一个空格都变成一个空格
            }
        }
        System.out.println("tmp==" + tmp);
        //根据空格拆分成N个数组,再拼接
        String[] arr = tmp.split(" ");
        for(int k = arr.length - 1; k >= 0; k--) {
            output.append(arr[k]);
            //去最后一个空格
            output.append(k == 0 ? "" : " ");
        }
        System.out.println(output);
    }
}
