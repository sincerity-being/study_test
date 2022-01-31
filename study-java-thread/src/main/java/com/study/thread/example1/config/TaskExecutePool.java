package com.study.thread.example1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/***
 *
 *創建线程池
 *@author: HeYQ
 *@date: 2020-07-23 10:36
 *@describe:
 *@version:
 */
@Configuration
@EnableAsync
public class TaskExecutePool {

    @Autowired
    private TaskThreadPoolConfig taskThreadPoolConfig;

    @Bean
    public Executor myTaskAsyncPool(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        //核心线程池大小
        executor.setCorePoolSize(taskThreadPoolConfig.getCorePoolSize());
        //最大线程数
        executor.setMaxPoolSize(taskThreadPoolConfig.getMaxPoolSize());
        //队列容量
        executor.setQueueCapacity(taskThreadPoolConfig.getQueueCapacity());
        //活跃时间
        executor.setKeepAliveSeconds(taskThreadPoolConfig.getKeepAliveSeconds());
        //线程名字前缀
        executor.setThreadNamePrefix("MyExecutor-");

        // setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        return executor;

    }



}
