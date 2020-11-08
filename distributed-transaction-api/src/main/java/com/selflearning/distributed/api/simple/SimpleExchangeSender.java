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
public class SimpleExchangeSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    Exchange topicExchange;

    @Scheduled(fixedDelay = 3000L)
    public void send() {

       /* System.out.println("Exchange send msg ===> queues");
        rabbitTemplate.setExchange("simple.exchange.topic");
        rabbitTemplate.setRoutingKey("simple.queue.*");

        this.rabbitTemplate.convertAndSend( "simple.exchange.topic say hello all");
*/

    }


}
