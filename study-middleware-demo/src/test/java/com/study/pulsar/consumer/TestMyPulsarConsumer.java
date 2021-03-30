package com.study.pulsar.consumer;

import lombok.extern.slf4j.Slf4j;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.junit.Test;




/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-24 13:45
 *@describe:
 *@version:
 */

@Slf4j
public class TestMyPulsarConsumer {


    private Consumer<Integer> myIntegerConsumer;

        public TestMyPulsarConsumer(){
        try {
            myIntegerConsumer = new MyPulsarComsumer().createMyIntegerConsumer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void receive() throws  Exception{
        Message<Integer> receive = myIntegerConsumer.receive();
        try{
            log.info("mq消费MessageId: " + receive.getMessageId());
            log.info("收到信息:===" + receive.getValue());

            myIntegerConsumer.acknowledge(receive);

        }catch(Exception e){

            myIntegerConsumer.negativeAcknowledge(receive);
            log.error("消息消费者线程异常：", e);
            throw new RuntimeException("消息消费者线程异常：", e);
        }

    }



}
