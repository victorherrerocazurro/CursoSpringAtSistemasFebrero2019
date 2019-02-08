package com.curso.spring.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_IMPLEMENTED, reason="No se ha implementado esta funcionalidad")
public class CustomException extends RuntimeException {

}
