package com.reda;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TopicLogSender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Value("${mq.config.topicLogExchange}")
    private String exchange;

    public void send() {
        amqpTemplate.convertAndSend(exchange,"log.info","------info msg for log");
        amqpTemplate.convertAndSend(exchange,"log.error","------error msg for log");
        amqpTemplate.convertAndSend(exchange,"log.warm","------warm msg for log");
        amqpTemplate.convertAndSend(exchange,"log.debug","------debug msg for log");
    }
}
