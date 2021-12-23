package com.ricemarch.rabbitmqconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author tanwentao
 * @since 2021/9/24
 */

@Component
//监听的队列名称 TestDirectQueue
@Lazy(value = false)
@Slf4j
public class DirectReceiver {

    @RabbitListener(queues = "TestDirectQueue")
    public void process0(Map<?, ?> testMessage) {
        log.info("[0]DirectReceiver消费者收到消息:" + testMessage.toString());
    }

    @RabbitListener(queues = "TestDirectQueue")
    public void process1(Map<?, ?> testMessage) {
        log.info("[1]DirectReceiver消费者收到消息:" + testMessage.toString());
    }

    @RabbitListener(queues = "TestDirectQueue")
    public void process2(Map<?, ?> testMessage) {
        log.info("[2]DirectReceiver消费者收到消息:" + testMessage.toString());
    }
}
