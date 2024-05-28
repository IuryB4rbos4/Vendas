package com.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vendas.model.Cliente;

public interface ClienteRepositoyry extends JpaRepository<Cliente, Long>{    
}
