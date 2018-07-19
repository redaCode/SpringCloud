package com.reda.tut6;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author reda
 * @date 7/12/18 4:58 PM
 */
@Profile({"tut6","rpc"})
@Configuration
public class Tut6Config {

    @Bean
    public DirectExchange direct() {
        return new DirectExchange("tut6.direct");
    }

    @Profile("receiver")
    public static class Receiver {

        @Bean
        public Queue queue() {
            return new Queue("tut6.rpc.request");
        }

        @Bean
        public Binding binding(DirectExchange direct,Queue queue) {
            return BindingBuilder.bind(queue).to(direct).with("rpc");
        }

        @Bean
        public Tut6Receiver receiver() {
            return new Tut6Receiver();
        }
    }

    @Profile("sender")
    @Bean
    public Tut6Sender sender() {
        return new Tut6Sender();
    }

}
