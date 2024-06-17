package com.vendas.services.produto;

import java.util.List;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.domain.model.Produto;
import com.vendas.domain.repository.ProdutoRepository;
import com.vendas.exception.ProdutoNaoExisteException;
import com.vendas.rest.dto.produto.ProdutoGetResponseDTO;

@Service
public class ProdutoV1GetService implements ProdutoGetServices {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProdutoGetResponseDTO getProdutoId(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(ProdutoNaoExisteException::new);
        return modelMapper.map(produto, ProdutoGetResponseDTO.class);
    }

    @Override
    public List<ProdutoGetResponseDTO> getProdutoName(String name) {
        List<Produto> produtos = produtoRepository.findByName(name);
        if(produtos.isEmpty()){
            throw new ProdutoNaoExisteException();
        }
        List<ProdutoGetResponseDTO> clienteGetResponseDTOs = new ArrayList();
        for(int i = 0; i < produtos.size(); i++){
            clienteGetResponseDTOs.add(modelMapper.map(produtos.remove(i), ProdutoGetResponseDTO.class));
        }
        return clienteGetResponseDTOs;
    }
    
}
