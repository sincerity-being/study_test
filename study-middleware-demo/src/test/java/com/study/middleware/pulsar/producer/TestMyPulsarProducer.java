package com.study.middleware.pulsar.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.Producer;
import org.junit.Test;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-24 13:26
 *@describe:
 *@version:
 */
@Slf4j
public class TestMyPulsarProducer {

    private Producer<Integer>  myIntergerPulsarProducer ;


    @Test
    public void test() throws Exception{

        myIntergerPulsarProducer  = new MyPulsarProducer()
                .createIntergerProducter();

        try {
            log.info("=============开始 mq推送信息111 ===============");
            MessageId send = myIntergerPulsarProducer.send(111111);
            log.info("mq推送定时消息状态"+ " messageId: "+ send);
            log.info("=============结束 mq推送定时分流消息状态 ===============");
        } catch (Exception e) {
            log.error("推送保存批量分流消息mq失败:", e);
        }


    }




}
