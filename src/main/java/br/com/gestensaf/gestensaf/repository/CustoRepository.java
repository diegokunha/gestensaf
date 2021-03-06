package br.com.gestensaf.gestensaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestensaf.gestensaf.model.Custo;

@Repository
public interface CustoRepository extends JpaRepository<Custo, Long> {

}
