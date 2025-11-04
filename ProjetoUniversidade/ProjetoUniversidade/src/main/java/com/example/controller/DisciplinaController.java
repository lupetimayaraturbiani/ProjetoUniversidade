package com.example.controller;

import com.example.model.Disciplina;
import com.example.service.DisciplinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public List<Disciplina> listar(){
        return disciplinaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Disciplina buscarPorId(@PathVariable Long id){
        return disciplinaService.buscarPorId(id);
    }

    @PostMapping
    public Disciplina cadastrar(@RequestBody Disciplina disciplina){
        return disciplinaService.cadastrar(disciplina);
    }

    @PutMapping("/{id}")
    public Disciplina atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina){
        return disciplinaService.atualizar(id, disciplina);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        disciplinaService.deletar(id);
    }
}
