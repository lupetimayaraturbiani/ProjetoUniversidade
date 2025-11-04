package service;

import model.Endereco;
import org.springframework.stereotype.Service;
import repository.EnderecoRepository;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public Endereco buscarPorId(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public Endereco cadastrar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizar(Long id, Endereco endereco) {
        Endereco atual = enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrada"));

        atual.setRua(endereco.getRua());
        atual.setCidade(endereco.getCidade());
        atual.setEstado(endereco.getEstado());
        return enderecoRepository.save(atual);
    }

    public void deletar(Long id) {
        enderecoRepository.deleteById(id);
    }
}
