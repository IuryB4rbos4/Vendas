package com.vendas.domain.dto.produto;

import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoPostRequestDTO {
    
    @JsonProperty("name")
    private String name;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("preco unitario")
    @Positive
    private BigDecimal preco;
}
