package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
public class Aluno {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String matricula;

    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculas;

    public Aluno() {}
    public Aluno(String nome, List<Matricula> matriculas) {
        this.nome = nome;
        this.matriculas = matriculas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
