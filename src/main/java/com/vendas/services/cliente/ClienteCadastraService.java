package com.vendas.services.cliente;

import com.vendas.domain.dto.cliente.ClientePostRequestDTO;
import com.vendas.domain.model.Cliente;

@FunctionalInterface
public interface ClienteCadastraService {
    public Cliente cadastrarCliente(ClientePostRequestDTO clientePostRequestDTO);
}
