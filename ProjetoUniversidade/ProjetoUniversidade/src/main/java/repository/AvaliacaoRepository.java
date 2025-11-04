package repository;

import model.Avaliacao;
import model.Matricula;
import model.MatriculaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, MatriculaId> {
}
