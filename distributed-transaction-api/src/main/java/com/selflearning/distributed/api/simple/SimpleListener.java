package com.selflearning.distributed.api.simple;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.connection.PendingConfirm;
import org.springframework.amqp.rabbit.connection.PublisherCallbackChannel;

import java.io.IOException;

public class SimpleListener implements PublisherCallbackChannel.Listener {



    @Override
    public void handleConfirm(PendingConfirm pendingConfirm, boolean b) {

    }

    @Override
    public void handleReturn(int i, String s, String s1, String s2, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {

    }

    @Override
    public void revoke(Channel channel) {

    }

    @Override
    public String getUUID() {
        return null;
    }

    @Override
    public boolean isConfirmListener() {
        return false;
    }

    @Override
    public boolean isReturnListener() {
        return false;
    }
}
