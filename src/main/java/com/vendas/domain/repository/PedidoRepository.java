package com.vendas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vendas.domain.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
