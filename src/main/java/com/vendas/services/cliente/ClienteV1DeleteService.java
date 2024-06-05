package com.vendas.services.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.domain.model.Cliente;
import com.vendas.domain.repository.ClienteRepository;
import com.vendas.exception.ClienteNaoExisteException;

@Service
public class ClienteV1DeleteService implements ClienteDeleteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void deleteClienteID(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(ClienteNaoExisteException::new);
        clienteRepository.delete(cliente);
    }
    
}
