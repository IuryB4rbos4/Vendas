package com.vendas.services.cliente;

import java.util.List;

import com.vendas.rest.dto.cliente.ClienteGetResponseDTO;

public interface ClienteGetServices {
    public ClienteGetResponseDTO getClienteId(Long id);
    public List<ClienteGetResponseDTO> getClienteName(String name);
    public ClienteGetResponseDTO getClienteEmail(String email);
    public List<ClienteGetResponseDTO> getClienteAll();
}
