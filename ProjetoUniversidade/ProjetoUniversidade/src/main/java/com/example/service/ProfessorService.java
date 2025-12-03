package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Professor;
import com.example.repository.ProfessorRepository;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final RabbitMQPublisher rabbitMQPublisher;

    public ProfessorService(ProfessorRepository professorRepository, RabbitMQPublisher rabbitMQPublisher) {
        this.professorRepository = professorRepository;
        this.rabbitMQPublisher = rabbitMQPublisher;
    }

    public List<Professor> listarTodos(){
        return professorRepository.findAll();
    }

    public Professor buscarPorId(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor cadastrar(Professor professor) {
        Professor professorSalvo = professorRepository.save(professor);
        // Envia mensagem ao RabbitMQ quando professor é criado
        try {
            rabbitMQPublisher.publishEntityCreated(
                professorSalvo.getId(),
                "Professor",
                professorSalvo.getNome() + " (especialidade: " + professorSalvo.getEspecialidade() + ")"
            );
        } catch (Exception e) {
            // Log erro mas não falha a criação do professor
            System.err.println("Erro ao publicar evento de criação de Professor: " + e.getMessage());
        }
        return professorSalvo;
    }

    public Professor atualizar(Long id, Professor professor) {
        Professor atual = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado(a)"));

        atual.setNome(professor.getNome());
        atual.setEspecialidade(professor.getEspecialidade());
        return professorRepository.save(atual);
    }

    public void deletar(Long id){
        professorRepository.deleteById(id);
    }
}
