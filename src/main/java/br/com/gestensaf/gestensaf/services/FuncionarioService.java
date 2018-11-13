package br.com.gestensaf.gestensaf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestensaf.gestensaf.model.Funcionario;
import br.com.gestensaf.gestensaf.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository fr;
	
	public List<Funcionario> listaFuncionario(){
		return fr.findAll();
	}
	
	public List<Funcionario> listaFuncionarioFiltro(String cpf, String nome){
		return fr.listaFuncionarioFiltro(cpf, nome);
	}
	
	public Funcionario buscaCpf(String cpf) {
		return fr.findByCpf(cpf);
	}
	
	public Funcionario salvaFuncionario(Funcionario funcionario) {
		
		return fr.saveAndFlush(funcionario);
	}
	
	public void excluirFuncionario(String cpf) {
		fr.delete(cpf);
	}
	
}
