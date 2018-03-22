package com.reda;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.info}",autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.topicLogExchange}",type = ExchangeTypes.TOPIC),
        key = "*.info"
    )
)
public class TopicInfoReceiver {

    @RabbitHandler
    public void receive(String msg) {
        System.out.println(msg);
    }
}
