package com.vendas.domain.dto.produto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class ProdutoPutRequestDTO {
    
    @JsonProperty("name")
    @NotBlank
    @NotNull
    private String name;

    @JsonProperty("descricao")
    @NotNull
    private String descricao;

    @JsonProperty("preco")
    @NotNull
    @Positive
    private BigDecimal preco;
}
