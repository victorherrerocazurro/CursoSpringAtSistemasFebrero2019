package com.curso.spring.homamundo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Esta funcionalidad permite volver a cargar el properties
//se activa invocando el endpoint de actuator /refresh
@RefreshScope
@RestController
public class HolaMundoController {
	
	@Value("${message:Hello default}")
    private String message;

    @RequestMapping("/")
    String getMessage() {
        return this.message;
    }
}
