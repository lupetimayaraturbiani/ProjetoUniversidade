package com.example.repository;


import com.example.model.Avaliacao;
import com.example.model.MatriculaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, MatriculaId> {
}
