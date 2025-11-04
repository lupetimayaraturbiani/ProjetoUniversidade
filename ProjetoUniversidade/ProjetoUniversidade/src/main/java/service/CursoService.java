package service;

import model.Curso;
import org.springframework.stereotype.Service;
import repository.CursoRepository;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarTodos(){
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso cadastrar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso atualizar(Long id,Curso cursoAtualizado) {
        Curso atual = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        atual.setNome(cursoAtualizado.getNome());
        atual.setDuracao(cursoAtualizado.getDuracao());

        return cursoRepository.save(atual);
    }

    public void deletar(Long id) {
        cursoRepository.deleteById(id);
    }
}
