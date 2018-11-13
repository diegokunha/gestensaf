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
	
	public Multa salvaMulta(Multa multa) {
		return mr.saveAndFlush(multa);
	}
	
	public void excluiMulta(String codMulta) {
		mr.delete(codMulta);
	}
	
	public List<Multa> listaMulta(){
		return mr.findAll();
	}
	
	public Multa buscaMulta(String codMulta) {
		return mr.findOne(codMulta);				
	}
	
}
