package com.vendas.services.cliente;

import com.vendas.dto.ClienteGetDTO;

public interface ClienteGetServices {
    public ClienteGetDTO getClienteId(Long id);
    public ClienteGetDTO getClienteName(String name);
    public ClienteGetDTO getClienteEmail(String email);
}
