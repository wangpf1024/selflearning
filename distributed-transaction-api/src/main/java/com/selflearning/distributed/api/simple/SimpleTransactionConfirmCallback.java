package com.selflearning.distributed.api.simple;



import com.rabbitmq.client.ConfirmCallback;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;




public class SimpleTransactionConfirmCallback implements RabbitTemplate.ConfirmCallback {


    /**
     *
     *
     *  if the message cannot be delivered to a queue, an AmqpMessageReturnedException is thrown.
     *  This exception has returnedMessage, replyCode, and replyText properties,
     *  as well as the exchange and routingKey used for the send.
     * @param correlationData The CorrelationData is an object supplied by the client when sending the original message
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if(ack){
            System.out.println("消息确认成功");
        }else{
            System.out.println("消息确认失败");
        }
    }
}
