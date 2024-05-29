package com.vendas.services.cliente;

import com.vendas.dto.ClienteGetResponseDTO;

public interface ClienteGetServices {
    public ClienteGetResponseDTO getClienteId(Long id);
    public ClienteGetResponseDTO getClienteName(String name);
    public ClienteGetResponseDTO getClienteEmail(String email);
}
