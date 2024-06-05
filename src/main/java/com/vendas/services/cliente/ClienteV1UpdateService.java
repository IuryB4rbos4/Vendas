package com.vendas.services.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.domain.dto.cliente.ClientePutRequestDTO;
import com.vendas.domain.model.Cliente;
import com.vendas.domain.repository.ClienteRepository;
import com.vendas.exception.ClienteNaoExisteException;

@Service
public class ClienteV1UpdateService implements ClienteUpdateService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente putClienteId(Long id, ClientePutRequestDTO clientePutResquetDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(ClienteNaoExisteException::new);

        cliente.setEmail(clientePutResquetDTO.getEmail());
        cliente.setName(clientePutResquetDTO.getName());

        clienteRepository.flush();

        return cliente;
    }}
