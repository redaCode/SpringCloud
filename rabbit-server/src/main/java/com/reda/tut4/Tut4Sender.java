package com.reda.tut4;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author reda
 * @date 7/12/18 5:30 PM
 */
public class Tut4Sender {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    DirectExchange direct;

    int index;
    int count;

    private final String[] keys = {"orange", "black", "green"};

    @Scheduled(fixedDelay = 1000,initialDelay = 500)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello to ");
        if (++index == 3) {
            index = 0;
        }
        String key = keys[index];

        builder.append(key).append(" ");

        builder.append(Integer.toString(++count));
        String message = builder.toString();
        rabbitTemplate.convertAndSend(direct.getName(),key, message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
