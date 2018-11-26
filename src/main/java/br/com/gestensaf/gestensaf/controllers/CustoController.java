package br.com.gestensaf.gestensaf.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.gestensaf.gestensaf.services.CustoService;

@Controller
public class CustoController {

	@Autowired
	private CustoService cs;
	
	@GetMapping("/custo")
	public ModelAndView listaCustos() {
		ModelAndView mv = new ModelAndView("views/custo/listaCusto");
		mv.addObject("custos", cs.listaCusto());
		
		return mv;
	}
	
	@GetMapping("/excluiCusto/{id}")
	public ModelAndView excluiCusto(@PathVariable("id") long idCusto) {
		cs.excluiCusto(idCusto);
		
		return listaCustos();
	}
	
	@GetMapping("editaCusto/{id}")
	public editaCusto(@PathVariable ("id") long idCusto) {
		
	}
	
}
