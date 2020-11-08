package com.selflearning.distributed.api.simple;


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BasicProperties;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.ReceiveAndReplyCallback;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.PublisherCallbackChannel;
import org.springframework.amqp.rabbit.connection.PublisherCallbackChannelImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 声明定时消息发送
 */
@Component
@EnableScheduling
public class SimpleTransactionSender implements InitializingBean {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Autowired
    private CachingConnectionFactory ccf;

    @Scheduled(fixedDelay = 5000L)
    public void send(){

        System.out.println("send msg ===> queueF");


        Message message = MessageBuilder.withBody("hello queueF".getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
                .setMessageId("123")
                .setHeader("bar", "baz")
                .build();


       // this.rabbitTemplate.sendAndReceive("simple.queue.F", message);
        // 参考 ： https://my.oschina.net/lzhaoqiang/blog/670749
        this.rabbitTemplate.setMandatory(true);
        this.rabbitTemplate.send("","simple.queue.F",message);

        //int replyCode, String replyText, String exchange, String routingKey, BasicProperties properties, byte[] body
       /* try {
            AMQP.BasicProperties properties = new BasicProperties();

            this.rabbitTemplate.handleReturn(1,"1","","",,"abc".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }



    @Override
    public void afterPropertiesSet() {
        this.rabbitTemplate.setReturnCallback(new SimpleTransactionReturnCallback());
        this.rabbitTemplate.setConfirmCallback(new SimpleTransactionConfirmCallback());
    }


}
