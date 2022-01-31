package com.study.middleware.rabbitmq.demo1;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.middleware.rabbitmq.demo1.util.ConnectionUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

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
@Slf4j
public class Producer {

    static final String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        // 创建频道
        Channel channel = connection.createChannel();
        // 声明(创建) 队列
        /**
         * 参数1: 队列名称
         * 参数2: 是否定义持久化队列
         * 参数3: 是否独占本次连接
         * 参数4: 是否在不使用的时候自动删除队列
         * 参数5: 队列其他参数
         */
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        // 要发送的信息
        String message = "你好; 小兔子! ";

        /**
         * 参数1: 交换机名称,如果没有指定则使用默认Default Exchange
         * 参数2: 路由key,简单模式可以传递队列名称
         * 参数3: 消息其他属性
         * 参数4: 消息内容
         */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
        log.debug("已经发送消息: " + message);

        // 关闭资源
        channel.close();
        connection.close();

    }

}
