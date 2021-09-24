package com.ricemarch.rabbitmqprovider;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tanwentao
 * @since 2021/9/24
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 队列 起名：TestDirectQueue
     */
    @Bean
    public Queue testDirectQueue() {
        return new Queue("TestDirectQueue", true);
    }

    /**
     * Direct交换机 起名：TestDirectExchange
     */
    @Bean
    DirectExchange testDirectExchange() {
        //  return new DirectExchange("TestDirectExchange",true,true);
        return new DirectExchange("TestDirectExchange", true, false);
    }

    /**
     * 绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
     */
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with("TestDirectRouting");
    }

    @Bean
    DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange");
    }
}
