package com.curso.spring.webseguro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

//Bean de Spring
@Component
//EndPoint de Actuator
@Endpoint(id="listendpoints")
public class ListEndPointsActuator {

	private List<Endpoint> endpoints;

	@Autowired
	public ListEndPointsActuator(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}

	@ReadOperation
	public List<Endpoint> invoke() {
		return this.endpoints;
	}
}
