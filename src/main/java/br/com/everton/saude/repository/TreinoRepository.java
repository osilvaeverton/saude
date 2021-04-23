package br.com.everton.saude.repository;

import br.com.everton.saude.model.treino.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
}
