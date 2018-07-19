package com.reda.tut3;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author reda
 * @date 7/12/18 5:30 PM
 */
public class Tut3Sender {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    FanoutExchange fanout;

    int dots;
    int count;

    @Scheduled(fixedDelay = 1000,initialDelay = 500)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello");
        if (dots++ == 3) {
            dots = 1;
        }
        for (int i = 0; i < dots; i++) {
            builder.append('.');
        }

        builder.append(Integer.toString(++count));
        String message = builder.toString();
        rabbitTemplate.convertAndSend(fanout.getName(),"", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
