package com.reda.tut3;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author reda
 * @date 7/12/18 4:58 PM
 */
@Profile({"tut3","pub-sub"})
@Configuration
public class Tut3Config {

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("tut3.fanout");
    }

    @Profile("receiver")
    public static class receiver {

        @Bean
        public Queue autoDeleteQueue1() {
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2() {
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding1(FanoutExchange exchange,Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1).to(exchange);
        }

        @Bean
        public Binding binding2(FanoutExchange exchange,Queue autoDeleteQueue2) {
            return BindingBuilder.bind(autoDeleteQueue2).to(exchange);
        }

        @Bean
        public Tut3Receiver receiver() {
            return new Tut3Receiver();
        }
    }

    @Profile("sender")
    @Bean
    public Tut3Sender sender() {
        return new Tut3Sender();
    }

}
