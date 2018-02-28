package com.tml.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HelloReceiver {

    @RabbitHandler
    @RabbitListener(queues = "hello")
    public void process(Map hello) {
        System.out.println("Receiver  : " + hello);
    }
}
