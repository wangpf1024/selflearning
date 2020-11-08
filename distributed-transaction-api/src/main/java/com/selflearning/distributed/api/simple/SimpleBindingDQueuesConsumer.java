package com.selflearning.distributed.api.simple;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


/**
 * the broker uses two key components: exchanges and queues
 *
 * 声明消费者
 *
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "simple.queue.D", durable = "true"),
        exchange = @Exchange(value = "simple.queue.D", ignoreDeclarationExceptions = "true"),
        key = "simple.queue.D")
)
public class SimpleBindingDQueuesConsumer {

    @RabbitHandler
    public void process(@Payload String msg) {
        System.out.println("AK47-D binding queues process " + new java.util.Date() + ": " + msg);
    }

}
