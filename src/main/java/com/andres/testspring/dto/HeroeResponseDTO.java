package com.andres.testspring.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

@JsonPropertyOrder({"id", "name", "habilidad"})
@Value
public class HeroeResponseDTO {
    private Long id;
    private String name;
    private String fullName;
    private String powerStats;

}
