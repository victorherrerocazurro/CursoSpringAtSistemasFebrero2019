package com.curso.spring.seguridad;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class BasicAuthenticationExtractorLoginPassword implements ExtractorLoginPassword{

	@Override
	public String[] extraerDeRequest(HttpServletRequest request) {
		
		String headerAuthorization = request.getHeader("Authorization");
		
		return Base64.getDecoder().decode(headerAuthorization.split(" ")[1]).toString().split(":");
	}

}
