package com.curso.spring.webseguro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {
	
	@Bean
	public String dato() {
		return "Victor";
	}
	
	//Bean de Spring creado en el fichero de configuracion, 
	//dado que no se tiene acceso a la clase que lo define
	@Bean
	@Autowired
	public List<String> miLista(@Qualifier("dato") String valor){
		ArrayList<String> lista = new ArrayList<String>();
		lista.add(valor);
		return lista;
	}
	
	
	
}
