package com.curso.spring.concesionario.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.concesionario.core.servicios.PedidoService;
import com.curso.spring.concesionario.dto.EntregaPedidoDto;
import com.curso.spring.concesionario.dto.FacturaDto;
import com.curso.spring.concesionario.dto.PedidoDto;

@RestController
@RequestMapping("/pedido")
public class PedidoRestService {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Void> lanzarPedido(@RequestBody PedidoDto pedido) throws Exception {
        pedidoService.lanzarPedido(pedido);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PedidoDto> seguimientoPedido(@PathVariable long id) throws Exception {
        PedidoDto pedido = pedidoService.seguimientoPedido(id);
        return new ResponseEntity<PedidoDto>(pedido, HttpStatus.OK);
    }

    @PutMapping("{id}/recepcion")
    public ResponseEntity<PedidoDto> recepcionPedido(@PathVariable long id) throws Exception {
        pedidoService.recepcionPedido(id);
        return new ResponseEntity<PedidoDto>(HttpStatus.OK);
    }

    @PutMapping("{id}/entrega")
    public ResponseEntity<PedidoDto> entregaPedido(@RequestBody EntregaPedidoDto entregaPedido) throws Exception {
        FacturaDto facturaDto = pedidoService.entregaPedido(entregaPedido);
        return new ResponseEntity<PedidoDto>(facturaDto.getPedido(), HttpStatus.OK);
    }

}