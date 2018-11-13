package br.com.gestensaf.gestensaf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestensaf.gestensaf.model.Veiculo;
import br.com.gestensaf.gestensaf.repository.VeiculoRepository;
@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository vr;
	
	
	public void salvar(Veiculo veiculo) {
		vr.save(veiculo);		
	}
		
	public void altera(Veiculo veiculo) {
		vr.save(veiculo);
	}
	
	public List<Veiculo> findAll(){
		return vr.findAll();
	}
	
	public Veiculo findByPlaca(String placa){
		return vr.findOne(placa);
	}
	
}
