package com.vendas.services.produto;

import com.vendas.domain.dto.produto.ProdutoPutRequestDTO;
import com.vendas.domain.model.Produto;

@FunctionalInterface
public interface ProdutoUpdateService {
    public Produto putProdutoId(Long id, ProdutoPutRequestDTO produtoPutRequestDTO);
}
