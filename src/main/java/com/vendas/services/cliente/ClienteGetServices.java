package com.vendas.services.cliente;

import java.util.List;

import com.vendas.domain.dto.cliente.ClienteGetResponseDTO;

public interface ClienteGetServices {
    public ClienteGetResponseDTO getClienteId(Long id);
    public List<ClienteGetResponseDTO> getClienteName(String name);
    public ClienteGetResponseDTO getClienteEmail(String email);
    public List<ClienteGetResponseDTO> getClienteAll();
}
