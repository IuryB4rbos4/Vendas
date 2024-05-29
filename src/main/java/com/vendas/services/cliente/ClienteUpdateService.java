package com.vendas.services.cliente;

import com.vendas.dto.ClientePutRequestDTO;
import com.vendas.model.Cliente;

@FunctionalInterface
public interface ClienteUpdateService {
    public Cliente putClienteId(Long id, ClientePutRequestDTO clientePutResquetDTO);
}
