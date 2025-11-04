package repository;

import model.Matricula;
import model.MatriculaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaId> {
}
