package com.ricemarch.anyth1nglr3arn.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

/**
 * @author tanwentao
 * @since 2021/9/24
 */

public class RabbitMqSend {

    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {

        /*
          the connection abstracts the socket connection,and takes care of protocol version negotiation and authentication and so on for us.
          Here we connect to a RabbitMQ node on the remote server- test.ricemarch.com
          if we wanted to connect to a node on a different machine we'd simply specify its hostname or IP address here.
          factory have a default value about the host 'DEFAULT_HOST',if you look the source from the factory, you will find the default host is 'localhost'
         */
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("test.ricemarch.com");
        factory.setUsername("test");
        factory.setPassword("****");//null password
        factory.setPort(5672);
        /*
          next we create a channel,which is where most of the API for getting things done resides.
          Note we can use a try-with-resources statement because both {@link Connection} and {@link Channel} implement {@link java.io.Closeable}.
          This way we don't need to close them explicitly in our code
         */
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            /*
              To send, we must declare a queue for us to send to; then we can publish a message to the queue,
              all of this in the try-with-resources statement
             */
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("[x]Sent'" + message + "'");

        }
    }
}
