package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Aluno;
import com.example.repository.AlunoRepository;
@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final RabbitMQPublisher rabbitMQPublisher;

    public AlunoService(AlunoRepository alunoRepository, RabbitMQPublisher rabbitMQPublisher) {
        this.alunoRepository = alunoRepository;
        this.rabbitMQPublisher = rabbitMQPublisher;
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno cadastrar(Aluno aluno) {
        Aluno alunoSalvo = alunoRepository.save(aluno);
        // Envia mensagem ao RabbitMQ quando aluno é criado
        try {
            rabbitMQPublisher.publishEntityCreated(
                alunoSalvo.getId(),
                "Aluno",
                alunoSalvo.getNome() + " (matricula: " + alunoSalvo.getMatricula() + ")"
            );
        } catch (Exception e) {
            // Log erro mas não falha a criação do aluno
            System.err.println("Erro ao publicar evento de criação de Aluno: " + e.getMessage());
        }
        return alunoSalvo;
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        Aluno atual = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        atual.setNome(alunoAtualizado.getNome());
        atual.setMatriculas(alunoAtualizado.getMatriculas());

        return alunoRepository.save(atual);
    }

    public void deletar (Long id) {
        alunoRepository.deleteById(id);
    }
}
