package com.vendas.services.cliente;

import com.vendas.dto.ClientePostRequestDTO;
import com.vendas.model.Cliente;

@FunctionalInterface
public interface ClienteCadastraService {
    public Cliente cadastrarCliente(ClientePostRequestDTO clientePostRequestDTO);
}
