package com.study.basic.spring.springevent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/***
 *
 *获得spring容器
 *@author: HeYQ
 *@date: 2020-07-15 15:09
 *@describe:
 *@version:
 */

//@Component
public class SpringContextHolder implements ApplicationContextAware {


    private static ApplicationContext context;

    /****
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
                                                         throws BeansException {
       context = applicationContext;

        System.out.println("context===" + context);
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }
}
