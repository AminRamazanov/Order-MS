//package org.example.orderms.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitConfig {
//    private static final String ORDER_EXCHANGE = "order.exchange";
//    private static final String ORDER_RETRY_EXCHANGE = "order.retry.exchange";
//    private static final String ORDER_DLQ_EXCHANGE = "order.dlq.exchange";
//
//    private static final String ORDER_CREATED_QUEUE = "order.created.queue";
//    private static final String ORDER_CREATED_RETRY_QUEUE = "order.created.retry.queue";
//    private static final String ORDER_CREATED_DLQ = "order.created.dlq.queue";
//
//    private static final String ORDER_CREATED_ROUTING_KEY = "order.created.key";
//    private static final String ORDER_CREATED_DLQ_ROUTING_KEY = "order.created.dlq.key";
//
//    @Bean
//    public TopicExchange orderExchange() {
//        return new TopicExchange(ORDER_EXCHANGE);
//    }
//
//    @Bean
//    public TopicExchange orderRetryExchange() {
//        return new TopicExchange(ORDER_RETRY_EXCHANGE);
//    }
//
//    @Bean
//    public TopicExchange orderDlqExchange() {
//        return new TopicExchange(ORDER_DLQ_EXCHANGE);
//    }
//
//    @Bean
//    public Queue orderCreatedQueue(){
//        return QueueBuilder.durable(ORDER_CREATED_QUEUE)
//                .withArgument("x-dead-letter-exchange", ORDER_RETRY_EXCHANGE)
//                .withArgument("x-dead-letter-routing-key", "order.created.retry.key")
//                .build();
//    }
//
//    @Bean
//    public Queue orderCreatedRetryQueue(){
//        return QueueBuilder.durable(ORDER_CREATED_RETRY_QUEUE)
//                .withArgument("x-message-ttl", 5000)
//                .withArgument("x-dead-letter-exchange", ORDER_EXCHANGE)
//                .withArgument("x-dead-letter-routing-key", "order.created.key")
//                .build();
//    }
//
//    @Bean
//    public Queue orderCreatedDlq(){
//        return QueueBuilder.durable(ORDER_CREATED_DLQ).build();
//    }
//
//    @Bean
//    public Binding orderCreatedBinding() {
//        return BindingBuilder
//                .bind(orderCreatedQueue())
//                .to(orderExchange())
//                .with(ORDER_CREATED_ROUTING_KEY);
//    }
//
//    @Bean
//    public Binding orderCreatedRetryBinding() {
//        return BindingBuilder
//                .bind(orderCreatedRetryQueue())
//                .to(orderRetryExchange())
//                .with("order.created.retry.key");
//    }
//
//    @Bean
//    public Binding orderCreatedDlqBinding() {
//        return BindingBuilder
//                .bind(orderCreatedDlq())
//                .to(orderDlqExchange())
//                .with(ORDER_CREATED_DLQ_ROUTING_KEY);
//    }
//}