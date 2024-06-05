package com.vendas.services.cliente;

import com.vendas.domain.dto.cliente.ClientePutRequestDTO;
import com.vendas.domain.model.Cliente;

@FunctionalInterface
public interface ClienteUpdateService {
    public Cliente putClienteId(Long id, ClientePutRequestDTO clientePutResquetDTO);
}
