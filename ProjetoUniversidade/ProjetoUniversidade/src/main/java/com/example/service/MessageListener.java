package com.example.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = "universidade.queue")
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida do RabbitMQ: " + message);
    }
}