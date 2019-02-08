package com.curso.spring.carrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.curso.spring.seguridad.SeguridadBasadaEnSessionInterceptor;

//No se está empleando
@Configuration
public class ConfiguracionWeb implements WebMvcConfigurer{

	//Como hemos incluido esta clase del api de seguridad, 
	//necesitamos meter el jar de seguridad en el classpath
	@Autowired
	private SeguridadBasadaEnSessionInterceptor seguridadInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(seguridadInterceptor).addPathPatterns("**");
	}
	
	

}
