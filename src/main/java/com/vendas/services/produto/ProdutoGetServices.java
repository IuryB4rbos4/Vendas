package com.vendas.services.produto;

import java.util.List;

import com.vendas.rest.dto.produto.ProdutoGetResponseDTO;

public interface ProdutoGetServices {
    public ProdutoGetResponseDTO getProdutoId(Long id);
    public List<ProdutoGetResponseDTO> getProdutoName(String name);
}
