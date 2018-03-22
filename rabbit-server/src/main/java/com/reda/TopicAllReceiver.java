package com.reda;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.logs}",autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.topicLogExchange}",type = ExchangeTypes.TOPIC),
        key = "*.*"
    )
)
public class TopicAllReceiver {

    @RabbitHandler
    public void receive(String msg) {
        System.out.println(msg);
    }
}
