package com.vendas.services.produto;

import org.springframework.beans.factory.annotation.Autowired;

import com.vendas.domain.dto.produto.ProdutoPutRequestDTO;
import com.vendas.domain.model.Produto;
import com.vendas.domain.repository.ProdutoRepository;
import com.vendas.exception.ProdutoNotExistException;

public class ProdutoV1UpdateService implements ProdutoUpdateService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto putProdutoId(Long id, ProdutoPutRequestDTO produtoPutRequestDTO) {
        Produto produto = produtoRepository.findById(id).orElseThrow(ProdutoNotExistException::new);

        produto.setName(produtoPutRequestDTO.getName());
        produto.setDescricao(produtoPutRequestDTO.getDescricao());
        produto.setPreco(produtoPutRequestDTO.getPreco());


        produtoRepository.flush();

        return produto;

    }
    
}
