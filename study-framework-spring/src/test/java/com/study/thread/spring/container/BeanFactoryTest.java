package com.study.thread.spring.container;

import com.study.spring.example1.source.container.basic.MyTestBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-08-15 14:39
 *@describe:
 *@version:
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {

   @Test
    public void testSimpleLoad(){
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-bean.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        Assert.assertEquals("testStr",bean.getTestStr());
    }
}
