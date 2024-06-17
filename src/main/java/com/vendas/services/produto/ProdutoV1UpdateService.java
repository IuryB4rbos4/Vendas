package com.vendas.services.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.domain.model.Produto;
import com.vendas.domain.repository.ProdutoRepository;
import com.vendas.exception.ProdutoNaoExisteException;
import com.vendas.rest.dto.produto.ProdutoPutRequestDTO;

@Service
public class ProdutoV1UpdateService implements ProdutoUpdateService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto putProdutoId(Long id, ProdutoPutRequestDTO produtoPutRequestDTO) {
        Produto produto = produtoRepository.findById(id).orElseThrow(ProdutoNaoExisteException::new);

        produto.setName(produtoPutRequestDTO.getName());
        produto.setDescricao(produtoPutRequestDTO.getDescricao());
        produto.setPreco(produtoPutRequestDTO.getPreco());


        produtoRepository.flush();

        return produto;

    }
    
}
