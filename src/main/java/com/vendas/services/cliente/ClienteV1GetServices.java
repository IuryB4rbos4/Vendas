package com.vendas.services.cliente;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.dto.ClienteGetResponseDTO;
import com.vendas.exception.ClienteNaoExisteException;
import com.vendas.model.Cliente;
import com.vendas.repository.ClienteRepository;

import java.util.Collection;

@Service
public class ClienteV1GetServices implements ClienteGetServices {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ClienteGetResponseDTO getClienteId(Long id) {
        Cliente currentCliente = clienteRepository.findById(id).orElseThrow(ClienteNaoExisteException::new);
        return modelMapper.map(currentCliente, ClienteGetResponseDTO.class);
    }

    @Override
    public ClienteGetResponseDTO getClienteName(String name) {
        Collection<Cliente> currentCliente = clienteRepository.clienteFindByName(name);
        if(currentCliente.isEmpty()){
            throw new ClienteNaoExisteException();
        }
        return modelMapper.map(currentCliente, ClienteGetResponseDTO.class);
    }

    @Override
    public ClienteGetResponseDTO getClienteEmail(String email) {
        Cliente currentCliente = clienteRepository.clienteFindByEmail(email);
        if(currentCliente == null){
            throw new ClienteNaoExisteException();
        }
        return modelMapper.map(currentCliente, ClienteGetResponseDTO.class);
    }
    
}
