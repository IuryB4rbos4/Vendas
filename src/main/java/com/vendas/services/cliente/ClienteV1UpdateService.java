package com.vendas.services.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.dto.ClientePutRequestDTO;
import com.vendas.exception.ClienteNaoExisteException;
import com.vendas.model.Cliente;
import com.vendas.repository.ClienteRepository;

@Service
public class ClienteV1UpdateService implements ClienteUpdateService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente putClienteId(Long id, ClientePutRequestDTO clientePutResquetDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(ClienteNaoExisteException::new);

        cliente.setEmail(clientePutResquetDTO.getEmail());
        cliente.setName(clientePutResquetDTO.getName());

        return clienteRepository.save(cliente);
    }}
