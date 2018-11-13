package br.com.gestensaf.gestensaf.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestensaf.gestensaf.model.Entrega;
import br.com.gestensaf.gestensaf.repository.EntregaRepository;

@Service
public class EntregaService {

	@Autowired
	private EntregaRepository er;
	
	public List<Entrega> listaEntrega(){
		return er.findAll();
	}
	
	public List<Entrega> listaEntregaFiltro(Date dataini, Date datafim, String filtro){
		return er.listaEntregaFiltro(dataini, datafim, filtro);
	}

	
	public Entrega buscaEntrega(long idEntrega) {
		return er.findOne(idEntrega);
	}
	
	public void salvaEntrega(Entrega entrega) {
		er.saveAndFlush(entrega);
	}
	
	public void excluiEntrega(long idEntrega) {
		er.delete(idEntrega);
	}
	
	
}
