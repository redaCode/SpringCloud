package com.reda;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "im_mq")
    public void receive(String msg) {
        System.out.println(msg);
    }
}
