package com.selflearning.distributed.api.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


/**
 * the broker uses two key components: exchanges and queues
 *
 * 声明消费者
 *
 */
@Component
@RabbitListener(queues = {"simple.queue.C"})
public class SimpleQueuesCConsumer {
    @RabbitHandler
    public void process(@Payload String msg) {
        System.out.println("common C queues process " + new java.util.Date() + ": " + msg);
    }

}
