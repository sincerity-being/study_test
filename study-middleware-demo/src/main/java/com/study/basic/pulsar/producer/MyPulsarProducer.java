package com.study.basic.pulsar.producer;


import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.AuthenticationFactory;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.impl.schema.JSONSchema;

import java.util.concurrent.TimeUnit;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-24 11:48
 *@describe:
 *@version:
 */
@Slf4j
public class MyPulsarProducer {


    String pulsarMsgFlowSaveTopicName = "hyq";
    /***
     *
     * @return
     * @throws PulsarClientException
     */
    public  PulsarClient initClient() throws PulsarClientException {
        return PulsarClient.builder()
                .serviceUrl("pulsar://39.97.103.40:6650")
                .enableTcpNoDelay(true)
                .build();
    }

    /***
     *
     * @return
     * @throws PulsarClientException
     * @throws InterruptedException
     */
    public   Producer<Integer> createIntergerProducter() throws
            PulsarClientException, InterruptedException{
         PulsarClient pulsarClient = initClient();
        log.info("pulsarMsgFlowSaveTopicName===" + pulsarMsgFlowSaveTopicName);
        return pulsarClient.newProducer(JSONSchema.of(Integer.class))
                //.producerName("my-producer")
                .topic(pulsarMsgFlowSaveTopicName)
                .batchingMaxMessages(1024)
                .batchingMaxPublishDelay(10, TimeUnit.MILLISECONDS)
                .enableBatching(true)
                .blockIfQueueFull(true)
                .maxPendingMessages(512)
                .sendTimeout(10, TimeUnit.SECONDS)
                .create();

    }

}
