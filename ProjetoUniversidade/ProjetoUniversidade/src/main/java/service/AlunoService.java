package service;

import model.Aluno;
import org.springframework.stereotype.Service;
import repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno cadastrar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        Aluno atual = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        atual.setNome(alunoAtualizado.getNome());
        atual.setMatriculas(alunoAtualizado.getMatriculas());

        return alunoRepository.save(atual);
    }

    public void deletar (Long id) {
        alunoRepository.deleteById(id);
    }
}
