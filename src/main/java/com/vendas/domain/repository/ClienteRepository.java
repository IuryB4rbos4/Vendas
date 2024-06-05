package com.vendas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.domain.model.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{   
    public List<Cliente> findByName(String name);
    public Cliente findByEmail(String email);
}
