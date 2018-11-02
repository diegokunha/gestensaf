package br.com.gestensaf.gestensaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestensaf.gestensaf.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

	public Entrega findByIdEntrega(long idEntrega);
	
}
