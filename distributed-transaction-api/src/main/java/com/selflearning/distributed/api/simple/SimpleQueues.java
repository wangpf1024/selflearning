package com.selflearning.distributed.api.simple;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 声明队列
 */
@Component
public class SimpleQueues {

    @Bean("queueA")
    public Queue queueA() {
        return new Queue("simple.queue.A");
    }

    @Bean("queueB")
    public Queue queueB() {
        return new Queue("simple.queue.B");
    }

    @Bean("queueC")
    public Queue queueC() {
        return new Queue("simple.queue.C");
    }

    @Bean("queueD")
    public Queue queueD() {
        return new Queue("simple.queue.D");
    }

    @Bean("queueE")
    public Queue queueE() {
        return new Queue("simple.queue.E");
    }

    @Bean("queueF")
    public Queue queueF() {
        return new Queue("simple.queue.F");
    }

    @Bean("queueG")
    public Queue queueG() {
        return new Queue("simple.queue.G");
    }


    @Autowired
    @Qualifier("topicExchange")
    Exchange exchange;

    @Autowired
    @Qualifier("queueE")
    Queue queueE;

    @Autowired
    @Qualifier("queueD")
    Queue queueD;


    @Autowired
    @Qualifier("queueF")
    Queue queueF;

    @Autowired
    @Qualifier("queueG")
    Queue queueG;


    @Bean
    public Binding topicBindingE(){
        return BindingBuilder.bind(queueE).to(exchange).with("simple.queue.*").noargs();
    }


    @Bean
    public Binding topicBindingD(){
        return BindingBuilder.bind(queueD).to(exchange).with("simple.queue.*").noargs();
    }


    @Bean
    public Declarables ds() {
        return new Declarables(
                exchange,
                new Binding("simple.queue.A", Binding.DestinationType.QUEUE, "simple.exchange.topic", "simple.queue.*", null),
                new Binding("simple.queue.B", Binding.DestinationType.QUEUE, "simple.exchange.topic", "simple.queue.*", null),
                new Binding("simple.queue.C", Binding.DestinationType.QUEUE, "simple.exchange.topic", "simple.queue.*", null)
        );
    }



}
