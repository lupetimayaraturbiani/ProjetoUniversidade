package com.example.service;

import com.example.model.Professor;
import com.example.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> listarTodos(){
        return professorRepository.findAll();
    }

    public Professor buscarPorId(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor cadastrar(Professor professor) {
        return professorRepository.save(professor);
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
