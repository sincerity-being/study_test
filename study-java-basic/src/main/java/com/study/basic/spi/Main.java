package com.study.basic.spi;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import java.util.ServiceLoader;

/**
 * 注释..
 * <p>  </p>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<UploadCdn> uploadCdns =  ServiceLoader.load(UploadCdn.class);
        for(UploadCdn u: uploadCdns){
            u.upload("filePath");
        }
    }
}
