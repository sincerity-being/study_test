package com.study.springboot;

import com.study.springboot.thread.config.TaskThreadPoolConfig;
import com.study.springboot.thread.task.AsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-23 10:56
 *@describe:
 *@version:
 */

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

// 开启配置属性支持

@EnableAsync
@Slf4j

@EnableConfigurationProperties({TaskThreadPoolConfig.class} )
@ComponentScan
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ThreadApplication.class)
public class ThreadApplication {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void AsyncTaskTest() throws InterruptedException, ExecutionException {

        for (int i = 0; i < 100; i++) {
            asyncTask.doTask1(i);
        }
        logger.info("All tasks finished.");
    }


}
