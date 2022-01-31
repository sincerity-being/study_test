package com.study.middleware.rabbitmq.demo2.config;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

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
public class RabbitMqConfig {

    /**
     * 交换机名称
     */
    public static final String ITEM_TOPIC_EXCHANGE = "item_topic_exchange";
    /**
     * 队列名称
     */
    public static final String ITEM_QUEUE = "item_queue";

    /**
     * 声明交换机
     */
    @Bean("itemTopicExchange")
    public Exchange topicExchange() {
        return ExchangeBuilder.topicExchange(ITEM_TOPIC_EXCHANGE)
                .durable(true).build();
    }

    /**
     * 声明队列
     */
    @Bean("itemQueue")
    public Queue itemQueue() {
        return QueueBuilder.durable(ITEM_QUEUE).build();
    }

    /**
     * 绑定队列和交换机
     */
    @Bean
    public Binding itemQueueExchange(@Qualifier("itemQueue") Queue queue,
                                     @Qualifier("itemTopicExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange)
                .with("item.#").noargs();
    }
}
