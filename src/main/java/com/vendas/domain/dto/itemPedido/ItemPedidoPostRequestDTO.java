package com.vendas.domain.dto.itemPedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoPostRequestDTO {
    @JsonProperty("cliente")
    @NotNull
    private Long cliente;
    @JsonProperty("total")
    @Positive
    private BigDecimal total;
    @JsonProperty("itens")
    @NotNull
    private List<PedidoPostDTO> itens;
}
