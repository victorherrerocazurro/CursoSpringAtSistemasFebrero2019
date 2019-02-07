package com.curso.spring.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;

//Definir un Bean
@Controller
//Permite definir un filtro de la request
@RequestMapping(path="/saludar")
@SessionAttributes({"claveSesion"})
public class HolaMundoController {

	@ModelAttribute
	public void initModel(Model model) {
		model.addAttribute("clave", "valor");
		model.addAttribute("claveSesion", "valor");
	}
	
	@GetMapping("/")
	public String index(Model model, HttpServletRequest req, HttpSession session) {
		
		model.addAttribute("clave", "valor");
		req.setAttribute("clave", "valor");
		
		session.setAttribute("claveSesion", "valor");
		model.addAttribute("claveSesion", "valor");
		
		return "welcome";
		
	}
	
	@GetMapping("/hola")
	public View saludar(Model model, 
			HttpServletRequest req, 
			HttpSession session, 
			@ModelAttribute("clave") String clave, 
			@ModelAttribute("claveSesion") String claveSesion) {
		
		String clave1 = (String) req.getAttribute("clave");
		String claveSesion1 = (String) session.getAttribute("claveSesion");
		
		
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
