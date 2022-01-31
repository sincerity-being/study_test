package com.study.basic.spi;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


/**
 * 注释..
 * <p>  </p>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @since 1.0
 */
public class ChinaNetCdn implements UploadCdn{
    @Override
    public void upload(String url) {
        System.out.println("upload to chinaNet cdn");
    }
}
