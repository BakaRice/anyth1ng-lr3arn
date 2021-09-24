package com.ricemarch.anyth1nglr3arn.mq.rabbitmq.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.ricemarch.anyth1nglr3arn.mq.rabbitmq.RabbitMqProperties;

import java.nio.charset.StandardCharsets;

/**
 * @author tanwentao
 * @since 2021/9/24
 */

public class Send {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        RabbitMqProperties rabbitMqProperties = new RabbitMqProperties();
        factory.setHost(rabbitMqProperties.getHost());
        factory.setUsername(rabbitMqProperties.getUserName());
        factory.setPassword(rabbitMqProperties.getPassword());
        factory.setPort(rabbitMqProperties.getPort());

        try (
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()
        ) {
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            String message = "info:Hello World!";

            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
