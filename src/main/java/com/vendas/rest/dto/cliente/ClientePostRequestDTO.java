package com.vendas.rest.dto.cliente;

import org.hibernate.validator.constraints.Length;

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
    
    @JsonProperty("name")
    @NotBlank
    private String name;

    @JsonProperty("email")
    @NotBlank
    private String email;
    
    @JsonProperty("cpf")
    @NotBlank()
    @NotNull
    @Length(max = 11, min = 11)
    private String cpf;

    @JsonProperty("password")
    @NotBlank
    @NotNull
    private String password;
    
}
