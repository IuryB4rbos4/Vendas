package com.vendas.domain.dto.itemPedido;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoPostDTO {
    @JsonProperty("produto")
    @NotNull
    private Long produto;
    @JsonProperty("quantidade")
    @NotNull
    private Integer quantidade;
}
