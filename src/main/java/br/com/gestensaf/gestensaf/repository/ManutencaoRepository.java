package br.com.gestensaf.gestensaf.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestensaf.gestensaf.model.Manutencao;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

	public Manutencao findByIdManutencao(long id);
	
}
