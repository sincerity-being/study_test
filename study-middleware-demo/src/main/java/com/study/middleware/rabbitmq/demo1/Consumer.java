package com.study.middleware.rabbitmq.demo1;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import com.rabbitmq.client.*;
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
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtil.getConnection();
        // 创建 频道
        Channel channel = connection.createChannel();

        // 声明(创建) 队列
        /**
         * 参数1: 队列名称
         * 参数2: 是否定义持久化队列
         * 参数3: 是否独占本次连接
         * 参数4: 是否在不使用的时候自动删除队列
         * 参数5: 队列其他参数
         */
        channel.queueDeclare(Producer.QUEUE_NAME, true, false, false, null);

        // 创建消费者,并设置消息处理
        DefaultConsumer consumer = new DefaultConsumer(channel) {


            /**
             * consumerTag 消息者标签，在channel.basicConsume时候可以指定
             * envelope 消息包的内容，可从中获取消息id，消息
             * routingkey，交换机，消息和重传标志(收到消息失败后是否需要重新发送)
             * properties 属性信息
             * body 消息
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                //路由key
                log.debug("路由key为：" + envelope.getRoutingKey());
                //交换机
                log.debug("交换机为：" + envelope.getExchange());
                //消息id
                log.debug("消息id为：" + envelope.getDeliveryTag());
                //收到的消息
                log.debug("接收到的消息为：" + new String(body, StandardCharsets.UTF_8));
            }
        };

        //监听消息
        /**
         * 参数1：队列名称
         * 参数2：是否自动确认，设置为true为表示消息接收到自动向mq回复接收到了，mq接收到回复会删除消息，设置为false则需要手动确认
         * 参数3：消息接收到后回调
         */
        channel.basicConsume(Producer.QUEUE_NAME, true, consumer);

        //不关闭资源，应该一直监听消息
        //channel.close();
        //connection.close();


    }
}
