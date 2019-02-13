package com.curso.spring.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfiguracionWeb implements WebMvcConfigurer  {

	/*@Autowired
	private AuditoriaInterceptor interceptor;*/
	
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(auditoriaInterceptor()).addPathPatterns("/saludar/hola3");
	}

	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/Cliente/nuevo").setViewName("cliente/formulario");
	}*/

	@Bean
	public AuditoriaInterceptor auditoriaInterceptor() {
		return new AuditoriaInterceptor();
	}
	
}
