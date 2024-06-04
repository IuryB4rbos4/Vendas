package com.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
