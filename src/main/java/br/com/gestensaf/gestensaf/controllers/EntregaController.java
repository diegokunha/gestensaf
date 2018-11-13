package br.com.gestensaf.gestensaf.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gestensaf.gestensaf.model.Custo;
import br.com.gestensaf.gestensaf.model.Entrega;
import br.com.gestensaf.gestensaf.services.CustoService;
import br.com.gestensaf.gestensaf.services.EntregaService;

@Controller
public class EntregaController {

	/**INJETANDO O OBJETO EntregaService*/
	@Autowired
	private EntregaService es;
	
	/**INJETANDO O OBJETO CustoService*/
	@Autowired
	private CustoService cs;
	
	/***
	 * CHAMA A PÁGINA PARA CADASTRAR UMA NOVA ENTREGA NO SISTEMA
	 * @param entrega
	 * @return
	 */
	@GetMapping("/novaEntrega")
	public ModelAndView novaEntrega(Entrega entrega) {
		ModelAndView mv = new ModelAndView("views/entrega/entregaForm");
		mv.addObject("entrega", entrega);
		
		return mv;
	}
	
	/***
	 * CHAMA A PÁGINA COM A LISTA DE ENTREGAS NO SISTEMA
	 * @param
	 * @return
	 */
	@GetMapping("/entrega")
	public ModelAndView listaEntrega() {
		ModelAndView mv = new ModelAndView("views/entrega/listaEntrega");
		mv.addObject("entregas", es.listaEntrega());
		
		return mv;
	}
	
	
	/***
	 * CHAMA O FORM DA ENTREGA COM AS INFORMAÇÕES CARREGADAS PARA EFETUAR A EDIÇÃO
	 * @param idEntrega
	 * @return
	 */
	@GetMapping("/editaEntrega/{id}")
	public ModelAndView editaEntrega(@PathVariable ("id") long idEntrega) {
		return novaEntrega(es.buscaEntrega(idEntrega));
	}
	
	
	
	@GetMapping("/excluiEntrega/{id}")
	public ModelAndView excluiEntrega(@PathVariable ("id") long idEnterga, RedirectAttributes att, Entrega entrega) {
		
		if(entrega.getStatus() != "FINALIZADA") {
			es.excluiEntrega(idEnterga);
			att.addFlashAttribute("message", "Entrega removida com sucesso.");
		}
		return listaEntrega();
	}
	
	/***
	 * SALVA AS INFORMAÇÕES DA ENTREGA
	 * @param entrega
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping("/salvaEntrega")
	public ModelAndView salvaEntrega(@Valid Entrega entrega, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("message", "Favor verificar os campos obrigatórios.");
			return novaEntrega(entrega);
		}
		
		entrega.setStatus("TRÂNSITO");
		es.salvaEntrega(entrega);
		attributes.addFlashAttribute("message", "Entrega salva com sucesso.");
		
		return listaEntrega();
	}
		
	/*
	public String finalEntrega(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("finalEntrega", entrega);
		
		Custo custo = new Custo();
		mv.addObject("finalCusto", custo);
		
		return "views/entrega/finalizaEntregaForm";
	}
	*/
	
	@GetMapping("/finalizaEntregaForm/{id}")
	public String finalizaEntrega(@PathVariable ("id") long idEntrega, Model model) {
		model.addAttribute("finalEntrega", es.buscaEntrega(idEntrega));
		
		return "views/entrega/finalizaEntregaForm";
	}
	
	@PostMapping("/salvaCusto")
	public String salvaCusto(@Valid Custo custo, BindingResult result, RedirectAttributes att) {
		
		
		if(result.hasErrors()) {
			att.addFlashAttribute("message", "Favor verificar os campos obrigatórios.");
			return "redirect:views/entrega/finalizaEntregaForm";			
		}
		
		Entrega entrega = es.buscaEntrega(custo.getEntrega().getIdEntrega());
		entrega.setStatus("FINALIZADA");
		entrega.getVeiculo().setKm(custo.getKmFim());
		custo.setEntrega(entrega);
		
		
		cs.salvaCusto(custo);
		att.addFlashAttribute("message", "Entrega finalizada com sucesso.");
		att.addFlashAttribute("message", "Custo da entrega lançado com sucesso.");
		
		return "redirect:/entrega";
	}
}
