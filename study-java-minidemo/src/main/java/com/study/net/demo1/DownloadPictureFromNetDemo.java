package com.study.net.demo1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2021-01-22 15:03
 * @describe 从某个网址上下载图片资源
 */
public class DownloadPictureFromNetDemo {

    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        System.out.println("请输入资源的url:");
        Scanner scanner = new Scanner(System.in);
        String urlStr = scanner.next();
        System.out.println("请输入存储路径:");
        String storeStr = scanner.next();
        downloadPicture(urlStr,storeStr);

    }

    public static void downloadPicture(String urlStr,String storeStr) throws IOException {
        File file = new File(storeStr);
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        // 创建一个http链接
        HttpURLConnection httpUrl = null;
        URL url = null;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try{
           url = new URL(urlStr);
           httpUrl = (HttpURLConnection) url.openConnection();
           httpUrl.connect();
           bis = new BufferedInputStream(httpUrl.getInputStream());
           fos = new FileOutputStream(file);
           while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            fos.flush();

        }catch(Exception e){

            e.printStackTrace();

        }finally{
            try {
                fos.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpUrl.disconnect();
            System.out.println("下载成功");
        }


    }

}
