package com.ricemarch.anyth1nglr3arn.mq.rabbitmq;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author tanwentao
 * @since 2021/9/24
 */
@ConfigurationProperties("rabbit-mq")
@Component
@Data
public class RabbitMqProperties {
    private String host = "test.ricemarch.com";

    private String userName = "test";

    private String password = "NEFU";

    private int port = 5672;


}
