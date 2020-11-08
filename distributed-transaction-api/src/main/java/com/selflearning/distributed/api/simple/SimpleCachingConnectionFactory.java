package com.selflearning.distributed.api.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ShutdownSignalException;
import org.springframework.amqp.rabbit.connection.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SimpleCachingConnectionFactory {


    @Value("${spring.application.name}")
    String name;

    @Bean
    public ConnectionNameStrategy cns() {
        return new SimplePropertyValueConnectionNameStrategy(name);
    }

    @Bean
    public CachingConnectionFactory ccf() {

        /**
         * The central component for managing a connection to the RabbitMQ broker
         */
        CachingConnectionFactory ccf = new CachingConnectionFactory();
        ccf.setAddresses("172.17.47.110:5672");
        ccf.setShuffleAddresses(true);

        ccf.setPublisherReturns(true);
        ccf.setPublisherConfirms(true);
        ccf.setUsername("guest");
        ccf.setPassword("guest");
        ccf.setConnectionNameStrategy(cns());
        //ccf.setPublisherChannelFactory();

        /**
         *  Sharing of the connection is possible since the “unit of work” for messaging with
         *  AMQP is actually a “channel”
         *  (in some ways, this is similar to the relationship between a connection and a session in JMS)
         */
        //ccf.setChannelCacheSize(7);

        System.out.println("Runtime.getRuntime().availableProcessors()  ==>" +Runtime.getRuntime().availableProcessors());

        /**
         * the number of processors available to the Java virtual machine
         *
         */
        ccf.addChannelListener((channel, b) -> {
            System.out.println(channel.getClass()+"==>"+channel.getChannelNumber());
//          System.out.println("ChannelListener b ==>" +b);
        });

        /**
         * To configure the size of the channel cache (the default is 25)
         */

        System.out.println("ccf.getChannelCacheSize() ==>" +ccf.getChannelCacheSize());



        ccf.addConnectionListener(new ConnectionListener() {
            @Override
            public void onCreate(Connection connection) {
                System.out.println("CachingConnectionFactory onCreate");
            }
            @Override
            public void onShutDown(ShutdownSignalException signal) {
                System.out.println("CachingConnectionFactory onShutDown");
            }
        });


        return ccf;
    }


}
