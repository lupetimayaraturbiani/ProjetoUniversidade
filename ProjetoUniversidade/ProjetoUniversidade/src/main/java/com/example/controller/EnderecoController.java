package com.example.controller;

import com.example.model.Endereco;
import com.example.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> listar(){
        return enderecoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable Long id){
        return enderecoService.buscarPorId(id);
    }

    @PostMapping
    public Endereco cadastrar(@RequestBody Endereco endereco){
        return enderecoService.cadastrar(endereco);
    }

    @PutMapping("/{id}")
    public Endereco atualizar(@PathVariable Long id, @RequestBody Endereco endereco){
        return enderecoService.atualizar(id, endereco);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        enderecoService.deletar(id);
    }
}
