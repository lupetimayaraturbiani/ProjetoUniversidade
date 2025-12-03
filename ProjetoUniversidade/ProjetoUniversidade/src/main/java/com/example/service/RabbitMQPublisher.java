package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.config.RabbitMQConfig;
import com.example.dto.MessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Publisher/Producer de mensagens para RabbitMQ.
 * Responsável por enviar eventos de criação/atualização de entidades.
 */
@Service
public class RabbitMQPublisher {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQPublisher.class);

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public RabbitMQPublisher(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    /**
     * Envia uma mensagem ao RabbitMQ.
     *
     * @param message a mensagem a ser enviada
     */
    public void publish(MessageDTO message) {
        try {
            String messageJson = objectMapper.writeValueAsString(message);
            rabbitTemplate.convertAndSend(
                    RabbitMQConfig.EXCHANGE_NAME,
                    RabbitMQConfig.ROUTING_KEY,
                    messageJson
            );
            logger.info("Mensagem enviada ao RabbitMQ: {}", message);
        } catch (Exception e) {
            logger.error("Erro ao enviar mensagem ao RabbitMQ", e);
        }
    }

    /**
     * Envia mensagem quando uma entidade é criada.
     *
     * @param entityId ID da entidade
     * @param entityType tipo da entidade (Aluno, Professor, Endereco)
     * @param entityData dados da entidade em JSON
     */
    public void publishEntityCreated(Long entityId, String entityType, String entityData) {
        MessageDTO message = new MessageDTO(entityId, entityType, "CREATED", entityData);
        publish(message);
    }

    /**
     * Envia mensagem quando uma entidade é atualizada.
     *
     * @param entityId ID da entidade
     * @param entityType tipo da entidade
     * @param entityData dados da entidade em JSON
     */
    public void publishEntityUpdated(Long entityId, String entityType, String entityData) {
        MessageDTO message = new MessageDTO(entityId, entityType, "UPDATED", entityData);
        publish(message);
    }

    /**
     * Envia mensagem quando uma entidade é deletada.
     *
     * @param entityId ID da entidade
     * @param entityType tipo da entidade
     */
    public void publishEntityDeleted(Long entityId, String entityType) {
        MessageDTO message = new MessageDTO(entityId, entityType, "DELETED", "");
        publish(message);
    }
}
