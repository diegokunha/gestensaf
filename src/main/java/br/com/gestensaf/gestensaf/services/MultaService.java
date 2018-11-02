package br.com.gestensaf.gestensaf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestensaf.gestensaf.model.Multa;
import br.com.gestensaf.gestensaf.repository.MultaRepository;

@Service
public class MultaService {

	@Autowired
	private MultaRepository mr;
	
	public void salvaMulta(Multa multa) {
		mr.saveAndFlush(multa);
	}
	
	public void excluiMulta(String id) {
		mr.delete(id);
	}
	
	public List<Multa> listaMulta(){
		return mr.findAll();
	}
	
	public Multa buscaMulta(String codMulta) {
		return mr.findOne(codMulta);
	}
	
}
