package br.com.gestensaf.gestensaf.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gestensaf.gestensaf.model.Veiculo;
import br.com.gestensaf.gestensaf.services.VeiculoService;


@Controller
public class VeiculoController {

	/**INJETANDO O OBJETO VeiculoService*/
	@Autowired
	private VeiculoService vs;
	
	/***
	 * CHAMA A PÁGINA PARA CADASTRAR UM NOVO VEÍCULO NO SISTEMA
	 * @param
	 * @return
	 */
	@RequestMapping(value="/novoVeiculo")
	public ModelAndView novoVeiculo(Veiculo veiculo) {
		ModelAndView mv = new ModelAndView("views/veiculo/veiculoForm");
		mv.addObject("veiculo", veiculo);
		
		return mv;
	}
	
	/***
	 * LISTA TODOS VEÍCULOS CADASTRADOS NO SISTEMA
	 * @param model
	 * @return
	 */
	@GetMapping("/veiculo")
	public ModelAndView listaVeiculos() {
		ModelAndView mv = new ModelAndView("views/veiculo/listaVeiculo");
		mv.addObject("veiculo", vs.findAll());
		return mv;
	}
	
	/***
	 * CONSULTA UM VEÍCULO PELA PLACA PARA REALIZAR ALTERAÇÕES NAS INFORAMÇÕES CADASTRADAS.
	 * @param placa
	 * @param model
	 * @return
	 */
	@GetMapping("/editaVeiculo/{placa}")
	public ModelAndView findByPlaca(@PathVariable ("placa") String placa) {
		return novoVeiculo(vs.findByPlaca(placa));
	}
	
	/***
	 * SALVA UM NOVO VEÍCULO NO SISTEMA
	 * @param veiculo
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping(value="/salvaVeiculo")
	public ModelAndView salvaVeiculo(@Valid Veiculo veiculo, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("msg_resultado", "Os campos obrigatórios estão vazios!!");
			return novoVeiculo(veiculo);
		}
		
		
		Veiculo placaIgual = vs.findByPlaca(veiculo.getPlaca());
		if(veiculo.getPlaca().equals(placaIgual)) {
			
			attributes.addFlashAttribute("msg_resultado", "Placa já cadastrada.");
			return novoVeiculo(veiculo);
		
		}else {
		
			veiculo.setStatus("LIBERADO");
			
			vs.salvar(veiculo);
			attributes.addFlashAttribute("msg_resultado", "Veículo cadastrado com sucesso!");
		
		}
		
		return listaVeiculos();
	}
	
	
}
