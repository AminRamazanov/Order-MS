package org.example.orderms.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "saga")
public class RabbitRoutingKey {
    private String exchange;

    private String orderCreatedKey;
}
