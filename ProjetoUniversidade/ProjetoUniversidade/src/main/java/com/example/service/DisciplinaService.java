package com.example.service;

import com.example.model.Disciplina;
import com.example.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Disciplina> listarTodos() {
        return disciplinaRepository.findAll();
    }

    public Disciplina buscarPorId(Long id) {
        return disciplinaRepository.findById(id).orElse(null);
    }

    public Disciplina cadastrar(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizar(Long id, Disciplina disciplina) {
        Disciplina atual = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        atual.setNome(disciplina.getNome());
        atual.setCargaHoraria(disciplina.getCargaHoraria());
        return disciplinaRepository.save(atual);
    }

    public void deletar(Long id) {
        disciplinaRepository.deleteById(id);
    }
}
