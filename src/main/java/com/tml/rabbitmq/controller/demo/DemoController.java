package com.tml.rabbitmq.controller.demo;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("hello")
    public Map hello(@RequestParam Map map) {
//        rabbitTemplate.convertAndSend("hello", map);
        rabbitTemplate.convertAndSend("exchange1","topic.1", map);
        rabbitTemplate.convertAndSend("exchange1","topic.2", map);
        return map;
    }


    @RequestMapping("hello_topic")
    public Map helloTopic(@RequestParam Map map) {
        rabbitTemplate.convertAndSend("hello", map);
        return map;
    }
}
