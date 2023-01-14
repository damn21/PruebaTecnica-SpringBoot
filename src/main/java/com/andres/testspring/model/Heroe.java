package com.andres.testspring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Heroe {

    @Id
    @GeneratedValue
    private int id;
    private String name;

}
