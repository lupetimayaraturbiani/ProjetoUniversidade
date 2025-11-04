package com.example.model;

import jakarta.persistence.*;

@Entity
public class Avaliacao {
    @EmbeddedId
    private MatriculaId id;

    @OneToOne
    @MapsId
    @JoinColumns({
            @JoinColumn(name = "aluno_id"),
            @JoinColumn(name = "disciplina_id")
    })
    private Matricula matricula;

    private Double n1;
    private Double n2;

    public Avaliacao() {}

    public Avaliacao(MatriculaId id, Matricula matricula, Double n1, Double n2) {
        this.id = id;
        this.matricula = matricula;
        this.n1 = n1;
        this.n2 = n2;
    }

    public MatriculaId getId() {
        return id;
    }

    public void setId(MatriculaId id) {
        this.id = id;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Double getMedia() {
        return (n1 + n2) / 2;
    }
}
