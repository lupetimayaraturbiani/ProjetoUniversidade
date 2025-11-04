package com.example.service;

import com.example.model.Matricula;
import com.example.model.MatriculaId;
import com.example.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {
    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public List<Matricula> listarTodos(){
        return matriculaRepository.findAll();
    }

    public Matricula buscarPorId(MatriculaId id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    public Matricula cadastrar(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public Matricula atualizar(MatriculaId id, Matricula matricula) {
        Matricula atual = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula não encontrada"));

        atual.setSemestre(matricula.getSemestre());
        return matriculaRepository.save(atual);
    }

    public void deletar(MatriculaId id){
        matriculaRepository.deleteById(id);
    }
}
