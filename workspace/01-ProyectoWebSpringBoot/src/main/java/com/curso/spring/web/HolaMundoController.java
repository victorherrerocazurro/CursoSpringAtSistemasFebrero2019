package com.curso.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;

//Definir un Bean
@Controller
//Permite definir un filtro de la request
@RequestMapping(path="/saludar")
public class HolaMundoController {

	@GetMapping("/hola")
	public View saludar(Model model) {
		return new JstlView();
		
	}
	
	@GetMapping("/hola2")
	public ModelAndView saludar(String nombre) {
		return null;
		
	}
	
	//Desacopla de la vista
	//Esta opcion precisa de un View Resolver
	@GetMapping("/hola3")
	public String despedir(Model model) {
		model.addAttribute("name", "Victor");
		return "index";
		
	}
	
}
