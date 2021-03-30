package com.study.pulsar.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.*;
import org.apache.pulsar.client.impl.schema.JSONSchema;

import java.util.concurrent.TimeUnit;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-24 13:41
 *@describe:
 *@version:
 */

@Slf4j
public class MyPulsarComsumer {



    String pulsarServerUrl = "pulsar://39.97.103.40:6650";
    String pulsarMsgSaveTopicName = "hyq";
    /****
     *
     * @return
     * @throws PulsarClientException
     */

    public PulsarClient initClient() throws PulsarClientException {
        return PulsarClient.builder()
                .serviceUrl(pulsarServerUrl)
                .enableTcpNoDelay(true)
                .build();
    }

    /***
     *
     * @return
     * @throws PulsarClientException
     */
    public Consumer<Integer> createMyIntegerConsumer()
            throws PulsarClientException{

        PulsarClient pulsarClient = initClient();
        log.info("pulsarMsgSaveTopicName===" + pulsarMsgSaveTopicName);
        return pulsarClient.newConsumer(JSONSchema.of(Integer.class))
                .topic(pulsarMsgSaveTopicName)
                .subscriptionName("msg-flow-save-queue-ele")
                .ackTimeout(10, TimeUnit.SECONDS)
                .subscriptionType(SubscriptionType.Shared)
                .subscribe();
    }


}
