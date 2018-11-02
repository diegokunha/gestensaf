package br.com.gestensaf.gestensaf.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gestensaf.gestensaf.model.Custo;
import br.com.gestensaf.gestensaf.services.CustoService;

@Controller
public class CustoController {

	@Autowired
	private CustoService cs;
	
	@GetMapping("/custo")
	public ModelAndView listaCustos() {
		ModelAndView mv = new ModelAndView("views/listaCusto");
		mv.addObject("custos", cs.listaCusto());
		
		return mv;
	}
	
	
}
