package model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MatriculaId implements Serializable {
    private long alunoId;
    private Long disciplinaid;

    public MatriculaId() {}
    public MatriculaId(long alunoId, Long disciplinaid) {
        this.alunoId = alunoId;
        this.disciplinaid = disciplinaid;
    }

    public long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getDisciplinaid() {
        return disciplinaid;
    }

    public void setDisciplinaid(Long disciplinaid) {
        this.disciplinaid = disciplinaid;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MatriculaId that = (MatriculaId) o;
        return alunoId == that.alunoId && Objects.equals(disciplinaid, that.disciplinaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alunoId, disciplinaid);
    }
}
