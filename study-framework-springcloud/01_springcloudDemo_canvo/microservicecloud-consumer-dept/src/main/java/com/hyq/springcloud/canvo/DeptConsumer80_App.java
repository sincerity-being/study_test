package com.hyq.springcloud.canvo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/***
 *@author: HeYQ
 *@date: 2020-06-04 20:12
 *@describe:
 *@version:
 */
@SpringBootApplication
@ComponentScan
public class DeptConsumer80_App {

    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }

}
