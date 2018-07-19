package com.reda.tut5;

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
public class Tut5Sender {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    TopicExchange topic;

    int index;
    int count;

    private final String[] keys = {"quick.orange.rabbit",
            "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox"};

    @Scheduled(fixedDelay = 1000,initialDelay = 500)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello to ");
        if (++index == keys.length) {
            index = 0;
        }
        String key = keys[index];

        builder.append(key).append(" ");

        builder.append(Integer.toString(++count));
        String message = builder.toString();
        rabbitTemplate.convertAndSend(topic.getName(),key, message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
