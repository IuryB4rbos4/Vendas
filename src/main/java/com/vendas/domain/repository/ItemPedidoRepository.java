package com.vendas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.domain.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
    
}
