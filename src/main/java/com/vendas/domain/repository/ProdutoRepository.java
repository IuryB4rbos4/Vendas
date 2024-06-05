package com.vendas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.vendas.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    public List<Produto> findByName(String name);
}
