package controller;

import model.Avaliacao;
import model.MatriculaId;
import org.springframework.web.bind.annotation.*;
import service.AvaliacaoService;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public List<Avaliacao> listar() {
        return avaliacaoService.listarTodos();
    }

    @GetMapping("/{alunoId}/{disciplinaId}")
    public Avaliacao buscarPorid(@PathVariable Long alunoId, @PathVariable Long disciplinaId) {
        return avaliacaoService.buscarPorId(new MatriculaId(alunoId, disciplinaId));
    }

    @PostMapping
    public Avaliacao cadastrar(@RequestBody Avaliacao avaliacao) {
        return avaliacaoService.cadastrar(avaliacao);
    }

    @PutMapping("/{id}")
    public Avaliacao atualizar(@PathVariable MatriculaId id, @RequestBody Avaliacao avaliacao) {
        return avaliacaoService.atualizar(id, avaliacao);
    }

    @DeleteMapping("/{alunoId}/{disciplinaId}")
    public void deletar(@PathVariable Long alunoId, @PathVariable Long disciplinaId) {
        avaliacaoService.deletar(new MatriculaId(alunoId, disciplinaId));
    }

    @GetMapping("/media-geral")
    public double mediaGeral() {
        return avaliacaoService.calcularMediaGeral();
    }
}
