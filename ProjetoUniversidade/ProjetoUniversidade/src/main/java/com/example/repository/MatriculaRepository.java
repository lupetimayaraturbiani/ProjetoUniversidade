package com.example.repository;

import com.example.model.Matricula;
import com.example.model.MatriculaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaId> {
}
