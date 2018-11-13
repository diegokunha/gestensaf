package br.com.gestensaf.gestensaf.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gestensaf.gestensaf.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

	public Entrega findByIdEntrega(long idEntrega);
	
	@Query("SELECT e FROM Entrega e WHERE e.dataEntrega BETWEEN :dataini AND :datafim  AND e.veiculo.placa LIKE :placa%")
	public List<Entrega> listaEntregaFiltro(@Param("dataini") Date dataini,
											@Param("datafim") Date datafim, 
											@Param("placa") String filtro);
	
}
