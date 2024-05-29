package com.vendas.services.cliente;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.dto.ClientePostRequestDTO;
import com.vendas.model.Cliente;
import com.vendas.repository.ClienteRepositoyry;

@Service
public class ClienteV1CastraService implements ClienteCadastraService {

    @Autowired
    ClienteRepositoyry clienteRepositoyry;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Cliente cadastrarCliente(ClientePostRequestDTO clientePostRequestDTO) {
        return clienteRepositoyry.save(modelMapper.map(clientePostRequestDTO, Cliente.class));
    }

}
