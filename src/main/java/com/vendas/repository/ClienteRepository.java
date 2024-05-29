package com.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vendas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{   
    public Cliente clienteFindByName(String name);
    public Cliente clienteFindByEmail(String email);
}
