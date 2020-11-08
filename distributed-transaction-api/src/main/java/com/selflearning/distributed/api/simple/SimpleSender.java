package com.selflearning.distributed.api.simple;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 声明定时消息发送
 */
/*@Component
@EnableScheduling*/
public class SimpleSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 5000L)
    public void send() {

    /*    System.out.println("send msg ===> queueA");
        this.rabbitTemplate.convertAndSend("simple.queue.A", "hello queueA");

        System.out.println("send msg ===> queueB");
        this.rabbitTemplate.convertAndSend("simple.queue.B", "hello queueB");

        System.out.println("send msg ===> queueC");
        this.rabbitTemplate.convertAndSend("simple.queue.C", "hello queueC");*/

    }


}
