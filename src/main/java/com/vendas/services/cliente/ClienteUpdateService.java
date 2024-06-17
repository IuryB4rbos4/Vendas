package com.vendas.services.cliente;

import com.vendas.domain.model.Cliente;
import com.vendas.rest.dto.cliente.ClientePutRequestDTO;

@FunctionalInterface
public interface ClienteUpdateService {
    public Cliente putClienteId(Long id, ClientePutRequestDTO clientePutResquetDTO);
}
