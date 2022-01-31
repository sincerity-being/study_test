package com.study.middleware.rabbitmq.demo1.util;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
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
public class ConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 主机地址: 默认 123.57.26.245
        connectionFactory.setHost("123.57.26.245");
        connectionFactory.setPort(5672);
        // 虚拟主机名称; 默认为 /
        connectionFactory.setVirtualHost("/itcast");
        // 连接用户名; 默认为guest
        connectionFactory.setUsername("heima");
        //连接密码;默认guest
        connectionFactory.setPassword("123456");

        // 创建 连接
        Connection connection = connectionFactory.newConnection();
        return connection;
    }
}
