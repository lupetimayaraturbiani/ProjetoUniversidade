package controller;

import model.Curso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> listar(){
        return cursoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable Long id){
        return cursoService.buscarPorId(id);
    }

    @PostMapping
    public Curso cadastrar(@RequestBody Curso curso){
        return cursoService.cadastrar(curso);
    }

    @PutMapping("/{id}")
    public Curso atualizar(@PathVariable Long id, @RequestBody Curso curso){
        return cursoService.atualizar(id, curso);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        cursoService.deletar(id);
    }

    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("");
    }
}
