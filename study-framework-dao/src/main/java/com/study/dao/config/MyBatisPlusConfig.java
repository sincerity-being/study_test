package com.study.dao.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-15 09:53
 *@describe:
 *@version:
 */
@CrossOrigin
@Configuration
@EnableTransactionManagement
@MapperScan("com.study.dao.mapper")
public class MyBatisPlusConfig {

    @Bean
    // 设置 dev test 环境开启
    @Profile({"dev" ,"test"})
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();

        performanceInterceptor.setMaxTime(1000);
        performanceInterceptor.setFormat(true);

        return performanceInterceptor;
    }



    /***
     * 逻辑删除插件
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

    /**
     * 分页插件
     *
     */

    @Bean
    public PaginationInterceptor paginationInterceptor(){

        return new PaginationInterceptor();
    }


}
