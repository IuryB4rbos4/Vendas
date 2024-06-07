package com.vendas.services.produto;

import org.springframework.beans.factory.annotation.Autowired;

import com.vendas.domain.model.Produto;
import com.vendas.domain.repository.ProdutoRepository;
import com.vendas.exception.ProdutoNaoExisteException;

public class ProdutoV1DeleteService implements ProdutoDeleteService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void deleteProdutoId(Long id) {
       Produto produto = produtoRepository.findById(id).orElseThrow(ProdutoNaoExisteException::new);
       produtoRepository.delete(produto);
    }
    
}
