package com.ricemarch.rabbitmqconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author tanwentao
 * @since 2021/9/26
 */
@Slf4j
@Component
@RabbitListener(queues = "topic.woman")
public class TopicTotalReceiver {

    @RabbitHandler
    public void process(Map<?, ?> testMessage) {
        log.info("TopicTotalReceiver消费者收到消息:{}", testMessage.toString());
    }
}