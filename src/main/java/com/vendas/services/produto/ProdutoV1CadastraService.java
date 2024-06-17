package com.vendas.services.produto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.domain.model.Produto;
import com.vendas.domain.repository.ProdutoRepository;
import com.vendas.rest.dto.produto.ProdutoPostRequestDTO;

@Service
public class ProdutoV1CadastraService implements ProdutoCadastraService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Produto cadastrarProduto(ProdutoPostRequestDTO produtoPostRequestDTO) {
        return produtoRepository.save(modelMapper.map(produtoPostRequestDTO, Produto.class));
    }
    
}
