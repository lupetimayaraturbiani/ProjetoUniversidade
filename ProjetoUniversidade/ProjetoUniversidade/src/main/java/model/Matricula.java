package model;

import jakarta.persistence.*;

@Entity
public class Matricula {
    @EmbeddedId
    private MatriculaId id;

    @ManyToOne
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @MapsId("disciplinaId")
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    private String semestre;

    @OneToOne(mappedBy = "matricula", cascade = CascadeType.ALL)
    private Avaliacao avalicao;

    public Matricula() {}

    public Matricula(MatriculaId id, Aluno aluno, Disciplina disciplina, String semestre, Avaliacao avalicao) {
        this.id = id;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.avalicao = avalicao;
    }

    public MatriculaId getId() {
        return id;
    }

    public void setId(MatriculaId id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Avaliacao getAvalicao() {
        return avalicao;
    }

    public void setAvalicao(Avaliacao avalicao) {
        this.avalicao = avalicao;
    }
}
