package com.vendas.services.produto;

import com.vendas.domain.model.Produto;
import com.vendas.rest.dto.produto.ProdutoPutRequestDTO;

@FunctionalInterface
public interface ProdutoUpdateService {
    public Produto putProdutoId(Long id, ProdutoPutRequestDTO produtoPutRequestDTO);
}
