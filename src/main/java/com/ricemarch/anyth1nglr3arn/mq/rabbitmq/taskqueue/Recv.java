package com.ricemarch.anyth1nglr3arn.mq.rabbitmq.taskqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.ricemarch.anyth1nglr3arn.mq.rabbitmq.RabbitMqProperties;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author tanwentao
 * @since 2021/9/24
 */

public class Recv {
    public static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        RabbitMqProperties rabbitMqProperties = new RabbitMqProperties();
        factory.setHost(rabbitMqProperties.getHost());
        factory.setUsername(rabbitMqProperties.getUserName());
        factory.setPassword(rabbitMqProperties.getPassword());
        factory.setPort(rabbitMqProperties.getPort());


        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = ((consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
            System.out.println(" [x] Received '" + message + "'");
        });

        channel.basicConsume(TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> {
        });
    }
}
