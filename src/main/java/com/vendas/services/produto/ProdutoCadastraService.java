package com.vendas.services.produto;

import com.vendas.domain.model.Produto;
import com.vendas.rest.dto.produto.ProdutoPostRequestDTO;

@FunctionalInterface
public interface ProdutoCadastraService {
    public Produto cadastrarProduto(ProdutoPostRequestDTO produtoPostRequestDTO);
}
