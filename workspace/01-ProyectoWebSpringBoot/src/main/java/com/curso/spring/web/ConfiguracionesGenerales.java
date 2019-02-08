package com.curso.spring.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@ControllerAdvice(basePackages="com.curso.spring.web")
@SessionAttributes({"claveSesion"})
public class ConfiguracionesGenerales {

	@ModelAttribute
	public void initModel(Model model) {
		model.addAttribute("clave", "valor");
		model.addAttribute("claveSesion", "valor");
	}
	
	@ExceptionHandler(CustomException.class)
	public String gestorExcepciones() {
		return "index";
	}
}
