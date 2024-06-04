package com.vendas.model;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @JsonProperty("id")
    @Column(name = "pk_id_cliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("Name")
    @Column(nullable = false, name = "desc_name", length = 100)
    private String name;

    @JsonProperty("email")
    @Column(nullable = false, name = "desc_email", unique = true)
    private String email;

    @JsonProperty("cpf")
    @Column(nullable = false, name = "desc_cpf", unique = true, length = 11)
    private String cpf;

    @OneToMany( mappedBy = "cliente", fetch = FetchType.LAZY )
    @JsonProperty("pedidos")
    private Set<Pedido> pedidos;

    @JsonProperty("password")
    private String password;
    
}
