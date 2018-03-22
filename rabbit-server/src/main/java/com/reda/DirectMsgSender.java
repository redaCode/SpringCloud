package com.reda;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DirectMsgSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.directExchange}")
    private String exchange;

    @Value("${mq.config.queue.info.routing.key}")
    private String infoRoutingKey;

    @Value("${mq.config.queue.error.routing.key}")
    private String errorRoutingKey;

    public void send() {
        amqpTemplate.convertAndSend(exchange,infoRoutingKey,"this is a info log.");
        amqpTemplate.convertAndSend(exchange,errorRoutingKey,"this is a error log.");
    }

}
