package com.curso.spring.concesionario.http;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso.spring.concesionario.core.ComercialService;
import com.curso.spring.concesionariodto.ComercialDto;

@RestController
@RequestMapping("/comercial")
public class ComercialRestService {

    @Autowired
    private ComercialService comercialService;

    @PostMapping
    public ResponseEntity<Void> alta(@RequestBody ComercialDto comercial) throws Exception {
        long idComercial = comercialService.alta(comercial);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idComercial).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> baja(@PathVariable long id) throws Exception {
        comercialService.baja(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> modificacion(@RequestBody ComercialDto comercial) throws Exception {
        comercialService.modificacion(comercial);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ComercialDto> consultaPorId(@PathVariable long id) throws Exception {
        ComercialDto comercial = comercialService.consultaPorId(id);
        return new ResponseEntity<ComercialDto>(comercial, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<ComercialDto>> consultarTodos() throws Exception {
        Collection<ComercialDto> comercials = comercialService.consultarTodos();
        return new ResponseEntity<Collection<ComercialDto>>(comercials, HttpStatus.OK);
    }

}