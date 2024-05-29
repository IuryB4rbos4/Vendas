package com.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vendas.model.Cliente;
import java.util.Collection;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{   
    public Collection<Cliente> clienteFindByName(String name);
    public Cliente clienteFindByEmail(String email);
}
