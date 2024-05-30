package com.vendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.dto.ClientePostRequestDTO;
import com.vendas.dto.ClientePutRequestDTO;
import com.vendas.services.cliente.ClienteCadastraService;
import com.vendas.services.cliente.ClienteDeleteService;
import com.vendas.services.cliente.ClienteGetServices;
import com.vendas.services.cliente.ClienteUpdateService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "v1/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

    @Autowired
    ClienteCadastraService clienteCadastraService;

    @Autowired
    ClienteGetServices clienteGetServices;

    @Autowired
    ClienteUpdateService clienteUpdateService;

    @Autowired
    ClienteDeleteService clienteDeleteService;

    @PostMapping("/")
    @Operation(summary = "Criar", description = "Metodo que cadastra um cliente", tags = "Cliente")
    public ResponseEntity<?> createCliente(@RequestBody @Valid ClientePostRequestDTO clientePostRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clienteCadastraService.cadastrarCliente(clientePostRequestDTO));
    }

    @GetMapping("/clienteId/{id}")
    @Operation(summary = "Buscar", description = "Metodo para buscar um cliente pelo id", tags = "Cliente")
    public ResponseEntity<?> getClienteId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteGetServices.getClienteId(id));
    }

    @GetMapping("/clienteId/name/{name}")
    @Operation(summary = "Buscar", description = "Metodo para buscar um cliente pelo name", tags = "Cliente")
    public ResponseEntity<?> getClienteName(@PathVariable("name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteGetServices.getClienteName(name));
    }

    @GetMapping("/clienteId/email/{email}")
    @Operation(summary = "Buscar", description = "Metodo para buscar um cliente pelo email", tags = "Cliente")
    public ResponseEntity<?> getClienteEmail(@PathVariable("email") String email) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteGetServices.getClienteEmail(email));
    }

    @PutMapping("/updateClienteId/{id}")
    @Operation(
        summary = "Atualizar",
        description = "Metodo para atualizar um cliente",
        tags = "Cliente"
    )
    public ResponseEntity<?> putClienteId(@PathVariable("id") Long id, @RequestBody @Valid ClientePutRequestDTO clientePutResquetDTO){
        return ResponseEntity.status(HttpStatus.OK).body(clienteUpdateService.putClienteId(id, clientePutResquetDTO));
    }

    @DeleteMapping("/deleteClienteId/{id}")
    @Operation(summary = "Deletar", description = "Metodo para deletar um cliente pelo id", tags = "Cliente")
    public ResponseEntity<?> deleteClienteId(@PathVariable("id") Long id){
        clienteDeleteService.deleteClienteID(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

}
