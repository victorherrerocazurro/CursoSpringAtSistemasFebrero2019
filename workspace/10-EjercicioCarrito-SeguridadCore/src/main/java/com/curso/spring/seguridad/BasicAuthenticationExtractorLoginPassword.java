package com.curso.spring.seguridad;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class BasicAuthenticationExtractorLoginPassword implements ExtractorLoginPassword{

	@Override
	public String[] extraerDeRequest(HttpServletRequest request) {
		
		System.out.println("Extractor");
		
		String headerAuthorization = request.getHeader("Authorization");
		
		String base64 = headerAuthorization.split(" ")[1];
		
		System.out.println(base64);
		
		String decodeBase64 = new String(Base64.getDecoder().decode(base64));
		
		System.out.println(decodeBase64);
		
		return decodeBase64.split(":");
	}

}
