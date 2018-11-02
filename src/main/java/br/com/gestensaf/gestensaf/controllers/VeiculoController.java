package br.com.gestensaf.gestensaf.controllers;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gestensaf.gestensaf.model.Veiculo;
import br.com.gestensaf.gestensaf.services.VeiculoService;
import br.com.gestensaf.gestensaf.validators.ValidadorRenavan;


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
	public String novoFuncionario() {
		return "views/veiculoForm";
	}
	
	/***
	 * CONSULTA TODOS VEÍCULOS CADASTRADOS NO SISTEMA
	 * @param model
	 * @return
	 */
	@GetMapping("/veiculo")
	public String listaVeiculos(Model model) {
		model.addAttribute("veiculo", vs.findAll());
		return "views/listaVeiculo";
	}
	
	/***
	 * CONSULTA UM VEÍCULO PELA PLACA PARA REALIZAR ALTERAÇÕES NAS INFORAMÇÕES CADASTRADAS.
	 * @param placa
	 * @param model
	 * @return
	 */
	@GetMapping("/veiculo/{placa}")
	public String findByPlaca(@PathVariable ("placa") String placa, Model model) {
		model.addAttribute("veiculo", vs.findByPlaca(placa));
		return "views/editarVeiculoForm";
	}
	
	/***
	 * SALVA UM NOVO VEÍCULO NO SISTEMA
	 * @param veiculo
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping(value="/salvarVeiculo")
	public String salvar(@Valid Veiculo veiculo, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos vazios!");
			return "redirect:/cadastrarVeiculo";
		}
		
		veiculo.setStatus("LIBERADO");
		
		vs.salvar(veiculo);
		attributes.addFlashAttribute("mensagem", "Veículo cadastrado com sucesso!");
		return "redirect:/veiculo";
	}
	
	/***
	 * SALVA AS ALTERAÇÕES REALIZADAS NO CADASTRO DO VEÍCULO
	 * @param veiculo
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping(value="/alteraVeiculo")
	public String alteraVeiculo(@Valid Veiculo veiculo, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("msg_resultado", "Verifique os campos vazios!");
			return "redirect:/cadastrarVeiculo";
		}
		
		ValidadorRenavan validaRenavan = new ValidadorRenavan();
		
		if(validaRenavan.validarRenavam(veiculo.getRenavan()) == false) {
			attributes.addFlashAttribute("msg_resultado", "Digite um renavan válido");
			return "redirect:/cadastrarVeiculo";
		}
		
		
		vs.salvar(veiculo);
		attributes.addFlashAttribute("msg_resultado", "Veículo alterado com sucesso!");
		return "redirect:/veiculo";
	}
	
	
}
