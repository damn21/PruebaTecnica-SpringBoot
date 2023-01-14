package com.andres.testspring.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.andres.testspring.model.Heroe;
import lombok.Value;

import javax.validation.constraints.*;
import java.time.LocalDate;

// Ordem de exibição dos campos
@JsonPropertyOrder({"nome", "email", "cpf", "dataNascimento"})
@Value // Objeto imutável
public class HeroeDTO {

    @NotBlank(message = "O nome não pode ser vazio!")
    @Size(min = 3, max = 40, message = "O nome precisa ter entre {min} e {max} caracteres!")
    private String nome;

    @NotBlank(message = "E-mail precisa ser fornecido!")
    @Email(message = "E-mail inválido!")
    private String email;

    @NotBlank(message = "CPF não pode ser vazio!")
    private String cpf;

    @NotNull(message = "A data de nascimento precisa ser fornecida!")
    @Past(message = "A data precisa ser no passado!")
    private LocalDate dataNascimento;

    //public Heroe transformaParaObjeto() {
      //  return new Heroe(name);
    //}
}
