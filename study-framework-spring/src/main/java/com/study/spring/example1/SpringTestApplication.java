package com.study.spring.example1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-15 09:46
 *@describe:
 *@version:
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.study.spring","com.study.common"})
public class SpringTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class,args);
    }


}
