package com.esgi.rabbitmq.rabbitMQListener;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {
    @Value("${spring.rabbitmq.exchange.name}")
    private String topicExchangeName;

    @Value("${spring.rabbitmq.queue.name}")
    private String queueName;

    @Value("${spring.rabbitmq.routing-key}")
    private String routingKey;

    @Bean
    public Queue myQueue() {
        return new Queue(queueName);
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.name}")
    public void listen(String in) {
        System.out.println(in);
    }
}
