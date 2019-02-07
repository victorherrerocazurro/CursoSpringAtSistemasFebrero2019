package com.curso.spring.carrito;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

//@Configuration
public class ConfiguracionWeb {

	@Bean
	@SessionScope
	public Carrito carrito() {
		return new Carrito();
	}
	
}
