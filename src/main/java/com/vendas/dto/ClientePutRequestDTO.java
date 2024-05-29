package com.vendas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientePutRequestDTO {
    @JsonProperty("Name")
    @NotBlank
    private String name;

    @JsonProperty("email")
    @NotBlank
    private String email;
}
