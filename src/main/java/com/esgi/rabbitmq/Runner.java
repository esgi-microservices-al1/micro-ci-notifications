package com.esgi.rabbitmq;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    //private final RabbitTemplate rabbitTemplate; //Envoi du message pour tester
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        //this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println("Le message est en cours d'envoi ...");
        //rabbitTemplate.convertAndSend(RabbitmqApplication.topicExchangeName, "UneRoutingKey", "UnObject"); //Envoi du message pour tester
        receiver.getLatch().await(15000, TimeUnit.MILLISECONDS); //Appelle le receiver pendant le temps indiqué
    }

}