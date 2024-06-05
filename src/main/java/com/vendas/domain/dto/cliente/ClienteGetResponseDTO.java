package com.vendas.domain.dto.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteGetResponseDTO {

    @JsonProperty("id")
    @NotNull
    private Long id;

    @JsonProperty("name")
    @NotBlank
    private String name;

    @JsonProperty("email")
    @NotBlank
    private String email;

}
