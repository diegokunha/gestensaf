package br.com.gestensaf.gestensaf.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gestensaf.gestensaf.model.Manutencao;
import br.com.gestensaf.gestensaf.services.ManutencaoService;

@Controller
public class ManutencaoController {

	/**INJETANDO O OBJETO ManutencaoService*/
	@Autowired
	private ManutencaoService ms;

	/***
	 * CHAMA A PÁGINA PARA CADASTRAR UMA NOVA MANUTENÇÃO NO SISTEMA
	 * @param entrega
	 * @return
	 */
	@GetMapping(value="/novaManutencao")
	public ModelAndView novaManutencao(Manutencao manutencao) {
		ModelAndView mv = new ModelAndView("views/manutencao/manutencaoForm");
		mv.addObject("manutencao", manutencao);
		return mv;
	}
		
	/***
	 * CHAMA A PÁGINA COM A LISTA DE MANUTENÇÕES CADASTRADAS NO SISTEMA
	 * @param
	 * @return
	 */
	@GetMapping("/manutencao")
	public ModelAndView listaManutencao() {		
		ModelAndView mv = new ModelAndView("views/manutencao/listaManutencao");
		mv.addObject("manutencoes", ms.listaManutencao());
		return mv;
	}
	
	/***
	 * CHAMA O FORM DA MANUTENÇÃO COM AS INFORMAÇÕES CARREGADAS PARA EFETUAR A EDIÇÃO
	 * @param idManutencao
	 * @return
	 */
	@GetMapping("/editarManutencao/{id}")
	public ModelAndView eidtaManutencao(@PathVariable("id") long idManutencao) {
		return novaManutencao(ms.buscaManutencao(idManutencao));
	}
	
	/***
	 * BUSCA A MANUTENÇÃO PELO ID
	 * @param id
	 * @return
	 */
	@GetMapping("/buscaManutencao/{id}")
	public ModelAndView buscaManutencaoPlaca(@RequestParam("id") long id) {
		ms.buscaManutencaoPlaca(id);
		return listaManutencao();
	}
	
	/***
	 * EXCLUI A MANUTENÇÃO PELO ID
	 * @param idManutencao
	 * @return
	 */
	@GetMapping("/excluiManutencao/{id}")
	public ModelAndView excluiManutencao(@PathVariable("id") long idManutencao, RedirectAttributes att) {
		
		ms.excluirManutencao(idManutencao);
		att.addFlashAttribute("message", "Manutenção removida com sucesso!!");
		
		return listaManutencao();
	}
	
	/***
	 * SALVA AS INFORMAÇÕES DA MANUTENÇÃO
	 * @param manutencao
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping("/salvaManutencao")
	public ModelAndView salvaManutencao(@Valid Manutencao manutencao, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("message", "Dados incorretos...");
			return novaManutencao(manutencao);
		}
		
		/*
		if(manutencao.getKm() > manutencao.getVeiculo().getKm()) {
			manutencao.getVeiculo().setKm(manutencao.getKm());
		}else {
			attributes.addFlashAttribute("message", "Quilometragem menor que a atual. Favor informar o valor correto.");
			return novaManutencao(manutencao);
		}
		*/
		
		ms.salvaManutencao(manutencao);
		attributes.addAttribute("message", "Manutenção salva com sucesso.");
		
		return listaManutencao();
	}
	
}
