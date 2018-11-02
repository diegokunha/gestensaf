package br.com.gestensaf.gestensaf.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	 * CHAMA A PÁGINA COM A LISTA DE ENTREGAS NO SISTEMA
	 * @param
	 * @return
	 */
	@GetMapping("/entrega")
	public ModelAndView listaEntrega() {
		ModelAndView mv = new ModelAndView("views/listaEntrega");
		mv.addObject("entregas", es.listaEntrega());
		
		return mv;
	}
	
	/***
	 * CHAMA A PÁGINA PARA CADASTRAR UMA NOVA ENTREGA NO SISTEMA
	 * @param entrega
	 * @return
	 */
	@GetMapping("/novaEntrega")
	public ModelAndView novaEntrega(Entrega entrega) {
		ModelAndView mv = new ModelAndView("views/entregaForm");
		mv.addObject("entrega", entrega);
		
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
	
	/***
	 * BUSCA A ENTREGA PELO ID
	 * @param idEntrega
	 * @return
	 */
	@GetMapping("/buscaEntrega/{id}")
	public ModelAndView buscaEntrega(@PathVariable ("id") long idEntrega) {
		es.buscaEntrega(idEntrega);
		
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
			attributes.addFlashAttribute("message", "Favor verificar os campos obrigatórios");
			return novaEntrega(entrega);
		}
		
		entrega.setStatus("TRÂNSITO");
		es.salvaEntrega(entrega);
		attributes.addFlashAttribute("message", "Entrega emitida com sucesso!!");
		
		return listaEntrega();
	}
	
	
	public ModelAndView finalEntrega(Entrega entrega) {
		ModelAndView mv = new ModelAndView("views/finalizaEntregaForm");
		mv.addObject("finalEntrega", entrega);
		
		Custo custo = new Custo();
		mv.addObject("finalCusto", custo);
		
		return mv;
	}
	
	@GetMapping("/finalizaEntregaForm/{id}")
	public ModelAndView finalizaEntrega(@PathVariable ("id") long idEntrega) {
		return finalEntrega(es.buscaEntrega(idEntrega));
	}
	
	@PostMapping("/salvaCusto")
	public ModelAndView salvaCusto(@Valid Custo custo, BindingResult result, RedirectAttributes att) {
		Entrega entrega = new Entrega();
		
		if(result.hasErrors()) {
			att.addFlashAttribute("message", "Favor verificar os campos obrigatórios!!");
			return finalEntrega(entrega);			
		}
		
		entrega.setStatus("FINALIZADO");
		cs.salvaCusto(custo);
		
		return listaEntrega();
	}
}
