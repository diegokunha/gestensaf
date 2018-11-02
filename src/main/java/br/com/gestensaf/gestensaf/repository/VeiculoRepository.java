package br.com.gestensaf.gestensaf.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestensaf.gestensaf.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String>{

	public Veiculo findByPlaca(String placa);
	
	
}
