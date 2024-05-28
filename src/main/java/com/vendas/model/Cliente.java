package com.vendas.model;

import org.hibernate.annotations.NotFound;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Cliente")
public class Cliente {
    
    @Id
    @JsonProperty("id")
    @Column(name = "pk_id_cliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @JsonProperty("Name")
    @Column(nullable = false, name = "desc_name")
    private String name;

    @JsonProperty("email")
    @Column(nullable = false, name = "desc_email")
    private String email;

    @JsonProperty("password")
    private String password;
    
}
