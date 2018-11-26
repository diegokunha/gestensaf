package br.com.gestensaf.gestensaf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestensaf.gestensaf.model.Custo;
import br.com.gestensaf.gestensaf.repository.CustoRepository;

@Service
public class CustoService {

	@Autowired
	private CustoRepository cr;
	
	public void salvaCusto(Custo custo) {
		cr.saveAndFlush(custo);
	}
	
	public void excluiCusto(long idCusto) {
		cr.delete(idCusto);
	}
	
	public List<Custo> listaCusto(){
		return cr.findAll();
	}
	
	public Custo buscaCusto(long id) {
		return cr.findOne(id);
	}
	
}
