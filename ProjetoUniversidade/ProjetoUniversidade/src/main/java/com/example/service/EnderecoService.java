package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Endereco;
import com.example.repository.EnderecoRepository;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final RabbitMQPublisher rabbitMQPublisher;

    public EnderecoService(EnderecoRepository enderecoRepository, RabbitMQPublisher rabbitMQPublisher) {
        this.enderecoRepository = enderecoRepository;
        this.rabbitMQPublisher = rabbitMQPublisher;
    }

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public Endereco buscarPorId(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public Endereco cadastrar(Endereco endereco) {
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        // Envia mensagem ao RabbitMQ quando endereço é criado
        try {
            rabbitMQPublisher.publishEntityCreated(
                enderecoSalvo.getId(),
                "Endereco",
                enderecoSalvo.getRua() + ", " + enderecoSalvo.getCidade() + " - " + enderecoSalvo.getEstado()
            );
        } catch (Exception e) {
            // Log erro mas não falha a criação do endereço
            System.err.println("Erro ao publicar evento de criação de Endereço: " + e.getMessage());
        }
        return enderecoSalvo;
    }

    public Endereco atualizar(Long id, Endereco endereco) {
        Endereco atual = enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrada"));

        atual.setRua(endereco.getRua());
        atual.setCidade(endereco.getCidade());
        atual.setEstado(endereco.getEstado());
        return enderecoRepository.save(atual);
    }

    public void deletar(Long id) {
        enderecoRepository.deleteById(id);
    }
}
