package com.ricemarch.anyth1nglr3arn.mq.rabbitmq.basic;

import com.rabbitmq.client.*;
import com.ricemarch.anyth1nglr3arn.mq.rabbitmq.RabbitMqProperties;

import java.nio.charset.StandardCharsets;

/**
 * @author tanwentao
 * @since 2021/9/24
 */

public class RabbitMqRecv {

    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();

        RabbitMqProperties rabbitMqProperties = new RabbitMqProperties();
        factory.setHost(rabbitMqProperties.getHost());
        factory.setUsername(rabbitMqProperties.getUserName());
        factory.setPassword(rabbitMqProperties.getPassword());
        factory.setPort(rabbitMqProperties.getPort());

        /*
        Why don't we use a try-with-resource statement to automatically close the channel and the connection?
        By doing so we would simply make the program move on, close everything, and exit!
        This would be awkward because we want the process to stay alive while the consumer is listening asynchronously for messages to arrive.
         */
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        /*
        We're about to tell the server to deliver us the messages from the queue. Since it will push us messages asynchronously,
        we provide a callback in the form of an object that will buffer the messages until we're ready to use them.
        That is what a DeliverCallback subclass does.
         */
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }
}
