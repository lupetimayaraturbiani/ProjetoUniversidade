package service;

import model.Departamento;
import org.springframework.stereotype.Service;
import repository.DepartamentoRepository;

import java.util.List;

@Service
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<Departamento> listarTodos() {
        return departamentoRepository.findAll();
    }

    public Departamento buscarPorId(Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public Departamento cadastrar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento atualizar(Long id, Departamento departamento) {
        Departamento atual = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        atual.setNome(departamento.getNome());
        return departamentoRepository.save(atual);
    }

    public void deletar(Long id) {
        departamentoRepository.deleteById(id);
    }
}
