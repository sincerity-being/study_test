package com.study.spring.example1.springevent;

import com.study.spring.example1.springevent.config.EventConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-15 15:30
 *@describe:
 *@version:
 */
public class App {



    public static void main(String[] args) {

        //构建spring容器
       // ApplicationContext applicationContext = new
        //                   ClassPathXmlApplicationContext("spring-context.xml");

        AnnotationConfigApplicationContext applicationContext
                =  new AnnotationConfigApplicationContext(EventConfig.class);

       /* SpringContextHolder  springContextHolder = (SpringContextHolder) applicationContext
                                                .getBean("springContextHolder");*/
        // springContextHolder.setApplicationContext(applicationContext);
        Driver driver = (Driver) applicationContext.getBean("driver");
        driver.drive("上海浦东");
    }

}
