package br.com.gestensaf.gestensaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "views/home";
	}
	
	@GetMapping("/index")
	public String index() {
		return "views/index";
	}
		
	
}
