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

import br.com.gestensaf.gestensaf.model.Funcionario;
import br.com.gestensaf.gestensaf.services.FuncionarioService;
import br.com.gestensaf.gestensaf.validators.ValidaCpf;


@Controller
public class FuncionarioController {

	/**INJETANDO O OBJETO FuncionarioService*/
	@Autowired
	private FuncionarioService fs;
	
	/***
	 * CHAMA A PÁGINA COM A LISTA DE FUNCIONÁRIOS NO SISTEMA
	 * @param
	 * @return
	 */
	@GetMapping("/funcionario")
	public ModelAndView listaFuncionario() {
		ModelAndView mv = new ModelAndView("views/listaFuncionario");
		mv.addObject("funcionarios", fs.listaFuncionario());
		return mv;
	}
	
	/***
	 * CHAMA A PÁGINA PARA CADASTRAR UM NOVO FUNCIONÁRIO NO SISTEMA
	 * @param funcionario
	 * @return
	 */
	@GetMapping(value="/novoFuncionario")
	public ModelAndView novoFuncionario(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("views/funcionarioForm");
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	
	/***
	 * CHAMA O FORM DO FUNCIONÁRIO COM AS INFORMAÇÕES CARREGADAS PARA EFETUAR A EDIÇÃO
	 * @param cpf
	 * @return
	 */
	@GetMapping("/editarFuncionario/{cpf}")
	public ModelAndView editarFuncionario(@PathVariable ("cpf") String cpf) {
		return novoFuncionario(fs.buscaCpf(cpf));
	}
	
	/***
	 * BUSCA O FUNCIONÁRIO PELO CPF
	 * @param cpf
	 * @return
	 */
	@GetMapping("/buscaFuncionario/{cpf}")
	public ModelAndView buscaFuncionario(@RequestParam ("cpf") String cpf) {
		fs.buscaCpf(cpf);
		return listaFuncionario();
	}
	
	/***
	 * EXCLUI O FUNCIONÁRIO PELO CPF
	 * @param cpf
	 * @return
	 */
	@GetMapping("/excluiFuncionario/{cpf}")
	public ModelAndView excluiFuncionario(@PathVariable ("cpf") String cpf) {
		fs.excluirFuncionario(cpf);
		
		return listaFuncionario();
	}
	
	/***
	 * SALVA AS INFORMAÇÕES DO FUNCIONÁRIO
	 * @param funcionario
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping("/salvaFuncionario")
	public ModelAndView salvaFuncionario(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attribute) {
		
		if(result.hasErrors()) {
			attribute.addFlashAttribute("message", "Favor verificar campos obrigatórios...");
			return novoFuncionario(funcionario);			
		}
		
		/*
		if(ValidaCpf.isValidCPF(funcionario.getCpf()) == false) {
			attribute.addFlashAttribute("message","*CPF incorreto");
			return novoFuncionario(funcionario);
		}
		*/
		
		fs.salvaFuncionario(funcionario);
		attribute.addFlashAttribute("message","Funcionário salvo com sucesso!!");
		
		return listaFuncionario();
	}
}
