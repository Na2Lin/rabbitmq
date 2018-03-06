package com.tml.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean("hello")
    Queue HelloQueue() {
        return QueueBuilder.durable("hello").build();
    }

    @Bean("hello2")
    Queue HelloQueue2() {
        return QueueBuilder.durable("hello2").build();
    }

    @Bean("exchange1")
    Exchange exchange() {
        return  ExchangeBuilder.topicExchange("exchange1").durable(true).build();
    }

    @Bean
    Binding binding(@Qualifier("hello") Queue queue,
                                                      @Qualifier("exchange1") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("topic.1").noargs();
    }

    @Bean
    Binding binding2(@Qualifier("hello2") Queue queue,
                                                      @Qualifier("exchange1") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("topic.#").noargs();
    }
}
