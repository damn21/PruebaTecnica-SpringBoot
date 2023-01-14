package com.andres.testspring.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.andres.testspring.model.Heroe;
import lombok.Value;

@JsonPropertyOrder({"id", "nome", "email"})
@Value
public class HeroeResponseDTO {
    private Long id;
    private String nome;
    private String email;

}
