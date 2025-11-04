package com.example.controller;

import com.example.model.Professor;
import com.example.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> listar(){
        return professorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Professor buscarPorId(@PathVariable Long id){
        return professorService.buscarPorId(id);
    }

    @PostMapping
    public Professor cadastrar(@RequestBody Professor professor){
        return professorService.cadastrar(professor);
    }

    @PutMapping("/{id}")
    public Professor atualizar(@PathVariable Long id, @RequestBody Professor professor){
        return professorService.atualizar(id, professor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        professorService.deletar(id);
    }

}
