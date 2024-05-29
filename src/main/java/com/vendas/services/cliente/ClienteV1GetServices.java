package com.vendas.services.cliente;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.dto.ClienteGetDTO;
import com.vendas.exception.ClienteNaoExisteException;
import com.vendas.model.Cliente;
import com.vendas.repository.ClienteRepository;

@Service
public class ClienteV1GetServices implements ClienteGetServices {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ClienteGetDTO getClienteId(Long id) {
        Cliente currentCliente = clienteRepository.findById(id).orElseThrow(ClienteNaoExisteException::new);
        return modelMapper.map(currentCliente, ClienteGetDTO.class);
    }

    @Override
    public ClienteGetDTO getClienteName(String name) {
        Cliente currentCliente = clienteRepository.clienteFindByName(name);
        if(currentCliente == null){
            throw new ClienteNaoExisteException();
        }
        return modelMapper.map(currentCliente, ClienteGetDTO.class);
    }

    @Override
    public ClienteGetDTO getClienteEmail(String email) {
        Cliente currentCliente = clienteRepository.clienteFindByEmail(email);
        if(currentCliente == null){
            throw new ClienteNaoExisteException();
        }
        return modelMapper.map(currentCliente, ClienteGetDTO.class);
    }
    
}
