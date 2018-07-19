package com.reda.tut1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author reda
 * @date 7/12/18 5:41 PM
 */
@RabbitListener(queues = "hello")
public class Tut1Receiver {
    @RabbitHandler
    public void receive(String in) {
        System.out.println("[X] Receive message " + in);
    }

}
