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
public class ClientePostRequestDTO {
    
    @JsonProperty("Name")
    @NotBlank
    private String name;

    @JsonProperty("email")
    @NotBlank
    private String email;

    @JsonProperty("password")
    @NotBlank
    @NotNull
    private String password;
    
}
