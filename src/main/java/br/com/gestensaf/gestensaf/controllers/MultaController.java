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

import br.com.gestensaf.gestensaf.model.Multa;
import br.com.gestensaf.gestensaf.services.MultaService;

@Controller
public class MultaController {

	@Autowired
	private MultaService ms;
	
	@GetMapping("/multa")
	public ModelAndView listaMulta() {
		ModelAndView mv = new ModelAndView("views/listaMulta");
		mv.addObject("multas", ms.listaMulta());
		
		return mv;
	}
	
	@GetMapping("/novaMulta")
	public ModelAndView novaMulta(Multa multa) {
		ModelAndView mv = new ModelAndView("views/multaForm");
		mv.addObject("multa", multa);
		
		return mv;
	}
	
	@GetMapping("/editaMulta/{id}")
	public ModelAndView editaMulta(@PathVariable ("id") String codMulta) {
		return novaMulta(ms.buscaMulta(codMulta));
	}
	
	@GetMapping("/excluiMulta/{id}")
	public ModelAndView excluiMulta(@PathVariable("id") String codMulta) {
		ms.excluiMulta(codMulta);
		
		return listaMulta();
	}
	
	@PostMapping("/salvaMulta")
	public ModelAndView salvaMulta(@Valid Multa multa, BindingResult rs, RedirectAttributes att) {
		if(rs.hasErrors()) {
			att.addFlashAttribute("message", "Favor preencher os campos obrigatórios");
			return novaMulta(multa);
		}
		
		multa.setStatus(true);
		ms.salvaMulta(multa);
		att.addFlashAttribute("message", "Multa salva com sucesso!!");
		
		return listaMulta();
	}
}
