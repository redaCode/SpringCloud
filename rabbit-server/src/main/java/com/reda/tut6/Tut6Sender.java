package com.reda.tut6;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author reda
 * @date 7/12/18 5:30 PM
 */
public class Tut6Sender {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    DirectExchange direct;

    int start = 0;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        System.out.println(" [x] Requesting fib(" + start + ")");
        Integer response = (Integer) rabbitTemplate.convertSendAndReceive
                (direct.getName(), "rpc", start++);
        System.out.println(" [.] Got '" + response + "'");
    }
}
