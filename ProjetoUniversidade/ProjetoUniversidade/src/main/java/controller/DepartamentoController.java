package controller;

import model.Departamento;
import org.springframework.web.bind.annotation.*;
import service.DepartamentoService;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public List<Departamento> listar(){
        return departamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Departamento buscarPorId(@PathVariable Long id){
        return departamentoService.buscarPorId(id);
    }

    @PostMapping
    public Departamento cadastrar(@RequestBody Departamento departamento){
        return departamentoService.cadastrar(departamento);
    }

    @PutMapping("/{id}")
    public Departamento atualizar(@PathVariable Long id, @RequestBody Departamento departamento){
        return departamentoService.atualizar(id, departamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        departamentoService.deletar(id);
    }
}
