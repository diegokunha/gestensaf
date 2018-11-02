package br.com.gestensaf.gestensaf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestensaf.gestensaf.model.Funcionario;
import br.com.gestensaf.gestensaf.model.Veiculo;

@RestController
public class WS {
	@Autowired
	private VeiculoService vs;
	
	@Autowired
	private FuncionarioService fs;
	
	@GetMapping("/veiculos")
	public List<Veiculo> veiculosList(){
		return vs.findAll();
	}
	
	@GetMapping("/funcionarios")
	public List<Funcionario> funcionariosList(){
		return fs.listaFuncionario();
	}
}
