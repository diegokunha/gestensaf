package br.com.gestensaf.gestensaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestensaf.gestensaf.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String>{

	public Funcionario findByCpf(String cpf);
	
}
