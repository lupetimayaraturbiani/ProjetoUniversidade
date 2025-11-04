package com.example.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MatriculaId implements Serializable {
    private long alunoId;
    private Long disciplinaId;

    public MatriculaId() {}
    public MatriculaId(long alunoId, Long disciplinaId) {
        this.alunoId = alunoId;
        this.disciplinaId = disciplinaId;
    }

    public long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getDisciplinaid() {
        return disciplinaId;
    }

    public void setDisciplinaid(Long disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MatriculaId that = (MatriculaId) o;
        return alunoId == that.alunoId && Objects.equals(disciplinaId, that.disciplinaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alunoId, disciplinaId);
    }
}
