package com.vendas.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "produto" )
public class Produto {
    
    @Id
    @JsonProperty("id")
    @Column(name = "pk_id_produto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("name")
    @Column(name = "desc_name", length = 100, nullable = false)
    private String name;

    @JsonProperty("descricao")
    @Column(name = "desc_descricao", length = 250, nullable = false)
    private String descricao;

    @JsonProperty("preco")
    @Column(name = "desc_preco", nullable = false)
    @Positive
    private BigDecimal preco;
}
