package com.study.thread.example1;

import com.study.thread.example1.config.TaskThreadPoolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/***
 *
 *
 *@author : HeYQ
 *@date : 2020-07-23 10:43
 *@describe :
 *@version :
 */
@SpringBootApplication
@EnableAsync
// 开启配置属性支持
@EnableConfigurationProperties({TaskThreadPoolConfig.class} )
public class ThreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadApplication.class,args);
    }



}
