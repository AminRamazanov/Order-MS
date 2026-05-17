package org.example.orderms.messaging;

import lombok.RequiredArgsConstructor;
import org.example.orderms.model.event.Event;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Publisher {
    private final RabbitTemplate rabbitTemplate;

    public void publishEvents(String exchange, String routingKey, String payload){
        rabbitTemplate.convertAndSend(exchange, routingKey, payload);
    }
}
