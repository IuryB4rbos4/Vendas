package com.vendas.services.cliente;

import com.vendas.domain.model.Cliente;
import com.vendas.rest.dto.cliente.ClientePostRequestDTO;

@FunctionalInterface
public interface ClienteCadastraService {
    public Cliente cadastrarCliente(ClientePostRequestDTO clientePostRequestDTO);
}
