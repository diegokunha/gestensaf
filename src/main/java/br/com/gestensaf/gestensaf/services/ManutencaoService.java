package br.com.gestensaf.gestensaf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestensaf.gestensaf.model.Manutencao;
import br.com.gestensaf.gestensaf.repository.ManutencaoRepository;

@Service
public class ManutencaoService {

	@Autowired
	private ManutencaoRepository mr;
	
	
	public List<Manutencao> listaManutencao(){
		return mr.findAll();
	}
	
	public Manutencao buscaManutencao(Long id) {
		return mr.findOne(id);
	}
	
	public Manutencao salvaManutencao(Manutencao manutencao) {
		return mr.saveAndFlush(manutencao);
	}
	
	public void excluirManutencao(Long id) {
		mr.delete(id);
	}
	
	public Manutencao buscaManutencaoPlaca(long id) {
		return mr.findByIdManutencao(id);
	}
}
