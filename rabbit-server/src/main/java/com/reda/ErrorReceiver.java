package com.reda;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings =@QueueBinding(
        value = @Queue(value = "${mq.config.queue.error}",autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.directExchange}",type = ExchangeTypes.DIRECT),
        key = "${mq.config.queue.error.routing.key}"
    )
)
public class ErrorReceiver {

    @RabbitHandler
    public void receive(String msg) {
        System.out.println("------接受到error：" + msg);
    }
}
