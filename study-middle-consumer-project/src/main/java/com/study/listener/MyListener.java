package com.study.listener;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *
 * </pre>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
@Component
@Slf4j
public class MyListener {

    /**
     * 监听某个队列的消息
     *
     * @param message 接收到的消息
     */
    @RabbitListener(queues = "item_queue")
    public void myListener(String message) {
        log.info("消费者接收到的消息为：" + message);
    }
}
