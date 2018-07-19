package com.reda.tut2;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author reda
 * @date 7/12/18 4:58 PM
 */
@Profile({"tut2","work-queues"})
@Configuration
public class Tut2Config {
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Profile("receiver")
    public static class receiver {
        @Bean
        public Tut2Receiver receiver1() {
            return new Tut2Receiver(1);
        }
        @Bean
        public Tut2Receiver receiver2() {
            return new Tut2Receiver(2);
        }
    }

    @Profile("sender")
    @Bean
    public Tut2Sender sender() {
        return new Tut2Sender();
    }

}
