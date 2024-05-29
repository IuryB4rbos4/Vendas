package com.vendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.dto.ClientePostRequestDTO;
import com.vendas.services.cliente.ClienteCadastraService;
import com.vendas.services.cliente.ClienteGetServices;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "v1/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {
    

    @Autowired
    ClienteCadastraService clienteCadastraService;

    @Autowired
    ClienteGetServices clienteGetServices;

    // @Autowired
    // ClienteUpdateServices clienteUpdateServices;

    // @Autowired
    // ClienteDeleteServices clienteDeleteServices;

    @PostMapping("/")
    @Operation(
        summary = "Listar",
        description = "Metodo que cadastra um cliente",
        tags = "Cliente"
    )
    public ResponseEntity<?> createCliente(@RequestBody @Valid ClientePostRequestDTO clientePostRequestDTO){
        return ResponseEntity
            .status(HttpStatus.CREATED)
                .body(clienteCadastraService.cadastrarCliente(clientePostRequestDTO));
    }


    @GetMapping("/clientId/{id}")
    public ResponseEntity<?> getClienteId(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(clienteGetServices.getClienteId(id));
    }
}
