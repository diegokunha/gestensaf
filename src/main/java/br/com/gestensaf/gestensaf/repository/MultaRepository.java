package br.com.gestensaf.gestensaf.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestensaf.gestensaf.model.Multa;

@Repository
public interface MultaRepository extends JpaRepository<Multa, String> {

}
