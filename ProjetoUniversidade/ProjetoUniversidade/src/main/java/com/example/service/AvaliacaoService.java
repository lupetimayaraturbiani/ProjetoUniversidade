package com.example.service;

import com.example.model.Avaliacao;
import com.example.model.MatriculaId;
import com.example.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvaliacaoService {
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> listarTodos() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao buscarPorId(MatriculaId id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

    public Avaliacao cadastrar(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao atualizar(MatriculaId id, Avaliacao avaliacao) {
        Avaliacao atual = avaliacaoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        atual.setN1(avaliacao.getN1());
        atual.setN2(avaliacao.getN2());
        return avaliacaoRepository.save(atual);
    }

    public void deletar(MatriculaId id) {
        avaliacaoRepository.deleteById(id);
    }

    public double calcularMediaGeral() {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findAll();

        return avaliacoes.stream()
                .mapToDouble(Avaliacao::getMedia)
                .average()
                .orElse(0.0);
    }
}
