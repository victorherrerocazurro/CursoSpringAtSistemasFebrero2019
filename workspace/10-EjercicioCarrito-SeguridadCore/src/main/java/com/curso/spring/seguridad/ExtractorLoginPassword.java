package com.curso.spring.seguridad;


import javax.servlet.http.HttpServletRequest;

public interface ExtractorLoginPassword {

	String[] extraerDeRequest(HttpServletRequest request);

}
