package br.com.gestensaf.gestensaf.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestensaf.gestensaf.model.Entrega;
import br.com.gestensaf.gestensaf.model.Funcionario;
import br.com.gestensaf.gestensaf.model.Veiculo;

@RestController
public class WS {
	@Autowired
	private VeiculoService vs;
	
	@Autowired
	private FuncionarioService fs;
	
	@Autowired
	private EntregaService es;
	
	@GetMapping("/veiculos")
	public List<Veiculo> veiculosList(){
		return vs.findAll();
	}
	
	@GetMapping("/funcionarios")
	public List<Funcionario> funcionariosList(){
		return fs.listaFuncionario();
	}
	
	@GetMapping("/entregas")
	public List<Entrega> listaEntrega(){
		return es.listaEntrega();
	}
	
	@GetMapping("/entregasFiltro")
	public List<Entrega> listaEntregasFiltro(String sdataini, String sdatafim, String filtro){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataini;
		Date datafim;
		try {
			dataini = sf.parse(sdataini);
			datafim = sf.parse(sdatafim);
			return es.listaEntregaFiltro(dataini, datafim, filtro);
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	@GetMapping("/funcionarioFiltro")
	public List<Funcionario> listaFuncionarioFiltro(String cpf, String nome){
		return fs.listaFuncionarioFiltro(cpf, nome);
	}
	
}
