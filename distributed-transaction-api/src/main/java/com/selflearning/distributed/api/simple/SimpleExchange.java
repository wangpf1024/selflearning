package com.selflearning.distributed.api.simple;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 声明 Exchange
 * The Exchange interface represents an AMQP(The Advanced Message Queuing Protocol) Exchange
 * 交换区是 AMQP 协议的实现
 * which is what a Message Producer sends to.
 * 消息接收的区域
 * Each Exchange within a virtual host of a broker
 * 每一个交互区是一个虚拟的代理
 * has a unique name as well as a few other properties
 * 有一个唯一的名称和其他几个属性
 */
@Component
public class SimpleExchange {


    /**
     * a Direct exchange lets a queue be bound by a fixed routing key (often the queue’s name)
     * 运行队列通过不可变的路由的键值绑定 （通常是队列的名称）
     * @return
     */
    @Bean("directExchange")
    public Exchange directExchange(){

        Exchange exchange = ExchangeBuilder.directExchange("simple.exchange.direct").build();

        return exchange;
    }


    /**
     * A Topic exchange supports bindings with routing patterns that may include
     * 支持 bingdings 同过滤 路由的键值表达式 如 * 号，# 号 绑定一个，零个或多个
     * the '*' and '#' wildcards for 'exactly-one' and 'zero-or-more', respectively.
     * @return
     */
    @Bean("topicExchange")
    public Exchange topicExchange(){

        Exchange exchange = ExchangeBuilder.topicExchange("simple.exchange.topic").build();

        return exchange;
    }

    /**
     * The Fanout exchange publishes to all queues that are bound to it without taking any routing key into consideration.
     * 面向全都队列且不用声明 路遥key
     * @return
     */
    @Bean("fanoutExchange")
    public Exchange fanoutExchange(){

        Exchange exchange = ExchangeBuilder.fanoutExchange("simple.exchange.fanout").build();

        return exchange;
    }





}
