package controller;

import model.Matricula;
import model.MatriculaId;
import org.springframework.web.bind.annotation.*;
import service.MatriculaService;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController{
    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public List<Matricula> listar() {
        return matriculaService.listarTodos();
    }

    @GetMapping("/{alunoId}/{disciplinaId}")
    public Matricula buscar(@PathVariable Long alunoId, @PathVariable Long disciplinaId) {
        return matriculaService.buscarPorId(new MatriculaId(alunoId, disciplinaId));
    }

    @PostMapping
    public Matricula adicionar(@RequestBody Matricula matricula) {
        return matriculaService.cadastrar(matricula);
    }

    @PutMapping("/{id}")
    public Matricula atualizar(@PathVariable MatriculaId id, @RequestBody Matricula matricula) {
        return matriculaService.atualizar(id, matricula);
    }

    @DeleteMapping("/{alunoId}/{disciplinaId}")
    public void deletar(@PathVariable Long alunoId, @PathVariable Long disciplinaId) {
        matriculaService.deletar(new MatriculaId(alunoId, disciplinaId));
    }
}
