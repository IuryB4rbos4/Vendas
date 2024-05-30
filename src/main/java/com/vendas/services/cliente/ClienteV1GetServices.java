package com.vendas.services.cliente;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.dto.ClienteGetResponseDTO;
import com.vendas.exception.ClienteNaoExisteException;
import com.vendas.model.Cliente;
import com.vendas.repository.ClienteRepository;

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
        List<Cliente> currentCliente = (List<Cliente>) clienteRepository.findByName(name);
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
    
}
