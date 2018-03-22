package com.reda;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String msg = "hello world";
        //直接发送消息到队列
        amqpTemplate.convertAndSend("im_mq",msg);

    }
}
