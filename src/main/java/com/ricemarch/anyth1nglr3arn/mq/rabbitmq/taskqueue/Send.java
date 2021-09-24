package com.ricemarch.anyth1nglr3arn.mq.rabbitmq.taskqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import com.ricemarch.anyth1nglr3arn.mq.rabbitmq.RabbitMqProperties;

import java.nio.charset.StandardCharsets;

/**
 * @author tanwentao
 * @since 2021/9/24
 */

public class Send {

    public static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        RabbitMqProperties rabbitMqProperties = new RabbitMqProperties();
        factory.setHost(rabbitMqProperties.getHost());
        factory.setUsername(rabbitMqProperties.getUserName());
        factory.setPassword(rabbitMqProperties.getPassword());
        factory.setPort(rabbitMqProperties.getPort());


        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

            String message = "taskqueue";
            for (int i = 0; i < 20; i++) {
                channel.basicPublish("",
                        TASK_QUEUE_NAME,
                        MessageProperties.PERSISTENT_TEXT_PLAIN,
                        (message + i).getBytes(StandardCharsets.UTF_8));
                System.out.println(" [x] Sent '" + message + "'");
            }

        }
    }
}
