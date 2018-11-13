package br.com.gestensaf.gestensaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gestensaf.gestensaf.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String>{

	public Funcionario findByCpf(String cpf);
	
	@Query("SELECT f FROM Funcionario f WHERE f.cpf LIKE :cpf% OR f.nome like :nome%")
	public List<Funcionario> listaFuncionarioFiltro(@Param("cpf") String cpf,
													@Param("nome") String nome);
	
}
