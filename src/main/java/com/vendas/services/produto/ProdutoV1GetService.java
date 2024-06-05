package com.vendas.services.produto;

import java.util.List;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.vendas.domain.dto.produto.ProdutoGetResponseDTO;
import com.vendas.domain.model.Produto;
import com.vendas.domain.repository.ProdutoRepository;
import com.vendas.exception.ProdutoNotExistException;

public class ProdutoV1GetService implements ProdutoGetServices {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProdutoGetResponseDTO getProdutoId(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(ProdutoNotExistException::new);
        return modelMapper.map(produto, ProdutoGetResponseDTO.class);
    }

    @Override
    public List<ProdutoGetResponseDTO> getProdutoName(String name) {
        List<Produto> produtos = produtoRepository.findByName(name);
        if(produtos.isEmpty()){
            throw new ProdutoNotExistException();
        }
        List<ProdutoGetResponseDTO> clienteGetResponseDTOs = new ArrayList();
        for(int i = 0; i < produtos.size(); i++){
            clienteGetResponseDTOs.add(modelMapper.map(produtos.remove(i), ProdutoGetResponseDTO.class));
        }
        return clienteGetResponseDTOs;
    }
    
}
