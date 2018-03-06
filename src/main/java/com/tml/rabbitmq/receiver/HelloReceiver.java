package com.tml.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HelloReceiver {

    @RabbitHandler
    @RabbitListener(queues = "hello",group = "group1")
    public void process(Map hello) {
        System.out.println("Receiver  : " + hello);
        System.out.println("Receiver2  : " + hello);
    }

    @RabbitHandler
    @RabbitListener(queues = "hello",group = "group1")
    public void process3(Map hello) {
        System.out.println("Receiver4  : " + hello);
    }

    @RabbitHandler
    @RabbitListener(queues = "hello2")
    public void process2(Map hello) {
        System.out.println("Receiver 3 : " + hello);
    }
}
