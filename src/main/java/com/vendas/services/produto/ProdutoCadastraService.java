package com.vendas.services.produto;

import com.vendas.domain.dto.produto.ProdutoPostRequestDTO;
import com.vendas.domain.model.Produto;

@FunctionalInterface
public interface ProdutoCadastraService {
    public Produto cadastrarProduto(ProdutoPostRequestDTO produtoPostRequestDTO);
}
