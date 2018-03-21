package com.reda;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate mqTemplate;

    public void send() {
        String msg = "hello world";
        mqTemplate.convertAndSend("im_mq",msg);
    }
}
