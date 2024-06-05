package com.vendas.services.produto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.vendas.domain.dto.produto.ProdutoPostRequestDTO;
import com.vendas.domain.model.Produto;
import com.vendas.domain.repository.ProdutoRepository;

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
