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

import br.com.gestensaf.gestensaf.model.Funcionario;
import br.com.gestensaf.gestensaf.services.FuncionarioService;


@Controller
public class FuncionarioController {

	/**INJETANDO O OBJETO FuncionarioService*/
	@Autowired
	private FuncionarioService fs;
	
	
	/***
	 * CHAMA A PÁGINA PARA CADASTRAR UM NOVO FUNCIONÁRIO NO SISTEMA
	 * @param funcionario
	 * @return
	 */
	@GetMapping(value="/novoFuncionario")
	public ModelAndView novoFuncionario(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("views/funcionario/funcionarioForm");
		mv.addObject("funcionario", funcionario);
		return mv;		
	}
	
	
	/***
	 * CHAMA A PÁGINA COM A LISTA DE FUNCIONÁRIOS NO SISTEMA
	 * @param
	 * @return
	 */
	@GetMapping("/funcionario")
	public ModelAndView listaFuncionario() {
		ModelAndView mv = new ModelAndView("views/funcionario/listaFuncionario");
		mv.addObject("funcionario", fs.listaFuncionario());
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
	 * EXCLUI O FUNCIONÁRIO PELO CPF
	 * @param cpf
	 * @return
	 */
	/*
	@GetMapping("/excluiFuncionario/{cpf}")
	public String excluiFuncionario(@PathVariable ("cpf") String cpf, RedirectAttributes att) {
		fs.excluirFuncionario(cpf);
		att.addFlashAttribute("message", "Funcionário removido com sucesso!!");
		
		return "redirect:/funcionario";
	}
	*/
	
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
		
		Funcionario cpfIgual = fs.buscaCpf(funcionario.getCpf());
		if(funcionario.getCpf().equals(cpfIgual)) {
			attribute.addFlashAttribute("message", "CPF já cadastrado");
			return novoFuncionario(funcionario);
		}else {
			fs.salvaFuncionario(funcionario);
			attribute.addFlashAttribute("message","Dados do funcionário salvo com sucesso!!");
		}
		
		
		
		return listaFuncionario();
	}
	
}
