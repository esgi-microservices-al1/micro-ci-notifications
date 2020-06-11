package com.esgi.rabbitmq.rabbitMQListener;

import com.esgi.rabbitmq.api.ApiRequestService;
import com.esgi.rabbitmq.models.Message;
import com.google.gson.Gson;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @Value("${spring.rabbitmq.queue.name}")
    private String queueName;

    private final ApiRequestService apiRequestService;

    public RabbitMQListener(ApiRequestService apiRequestService) {
        this.apiRequestService = apiRequestService;
    }

    @Bean
    public Queue myQueue() {
        return new Queue(queueName);
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.name}")
    public void listen(String message) {
        Gson gson = new Gson();
        Message parsed = gson.fromJson(message, Message.class);
        System.out.println(message);

        apiRequestService.sendMessage(parsed);



    }
}
