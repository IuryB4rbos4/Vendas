package com.vendas.services.cliente;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.domain.dto.cliente.ClienteGetResponseDTO;
import com.vendas.domain.model.Cliente;
import com.vendas.domain.repository.ClienteRepository;
import com.vendas.exception.ClienteNaoExisteException;

import java.util.ArrayList;
import java.util.List;


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
    public List<ClienteGetResponseDTO> getClienteName(String name) {
        List<Cliente> currentCliente = clienteRepository.findByName(name);
        if(currentCliente.isEmpty()){
            throw new ClienteNaoExisteException();
        }
        @SuppressWarnings({ "rawtypes", "unchecked" })
        List<ClienteGetResponseDTO> clienteGetResponseDTOs = new ArrayList();
        for(int i = 0; i < currentCliente.size(); i++){
            clienteGetResponseDTOs.add(modelMapper.map(currentCliente.remove(i), ClienteGetResponseDTO.class));
        }
        
        return clienteGetResponseDTOs;
    }

    @Override
    public ClienteGetResponseDTO getClienteEmail(String email) {
        Cliente currentCliente = clienteRepository.findByEmail(email);
        if(currentCliente == null){
            throw new ClienteNaoExisteException();
        }
        return modelMapper.map(currentCliente, ClienteGetResponseDTO.class);
    }

    @Override
    public List<ClienteGetResponseDTO> getClienteAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteGetResponseDTO> clienteGetResponseDTOs = new ArrayList();
        for(int i = 0; i < clientes.size(); i++){
            clienteGetResponseDTOs.add(modelMapper.map(clientes.remove(i), ClienteGetResponseDTO.class));
        }
        
        return clienteGetResponseDTOs;
    }
    
}
