package com.vendas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
