package com.selflearning.distributed.api.simple;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
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
        value = @Queue(value = "simple.queue.E", durable = "true"),
        exchange = @Exchange(value = "simple.queue.E", ignoreDeclarationExceptions = "true"),
        key = "simple.queue.E")
)
public class SimpleBindingEQueuesConsumer {


    @RabbitHandler
    public void process(@Payload String msg) {
        System.out.println("AK47-E binding queues process " + new java.util.Date() + ": " + msg);
    }


}
