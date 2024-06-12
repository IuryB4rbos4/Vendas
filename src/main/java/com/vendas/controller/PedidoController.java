package com.vendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.domain.dto.itemPedido.ItemPedidoPostRequestDTO;
import com.vendas.services.pedido.PedidoCadastraService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "v1/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {
    @Autowired
    private PedidoCadastraService pedidoCadastraService;

    @PostMapping("/")
    @Operation(summary = "Criar", description = "Metodo que cadastra um pedido", tags = "Pedido")
    public ResponseEntity<?> createPedido(@RequestBody @Valid ItemPedidoPostRequestDTO itemPedidoPostRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pedidoCadastraService.cadastrarPedido(itemPedidoPostRequestDTO));
    }
}
