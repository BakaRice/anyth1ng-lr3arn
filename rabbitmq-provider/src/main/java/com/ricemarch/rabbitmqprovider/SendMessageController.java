package com.ricemarch.rabbitmqprovider;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author tanwentao
 * @since 2021/9/24
 */
@RestController
public class SendMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message,hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = Map.of(
                "messageId", messageId,
                "messageData", messageData,
                "createTime", createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return "SENT OK";
    }

    @GetMapping("/sendTopicMessage01")
    public String sendTopicMessage1() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message:M A N";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = Map.of(
                "messageId", messageId,
                "messageData", messageData,
                "createTime", createTime
        );
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
        return "SENT OK";
    }

    @GetMapping("/sendTopicMessage02")
    public String sendTopicMessage2() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message:woman is all";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = Map.of(
                "messageId", messageId,
                "messageData", messageData,
                "createTime", createTime
        );
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", manMap);
        return "SENT OK";
    }


}
