package com.andres.testspring.service;

import com.andres.testspring.model.Heroe;

import java.util.List;
import java.util.Optional;

public interface IHeroeService {
     Heroe saveHeroe(Heroe heroe);
     List<Heroe> heroeList();
     Optional<Heroe> getHeroeById(Long id);
     Heroe updateHeroe(Heroe heroe, Long id);
     List<Heroe> searchHeroeByName(String name);
     void deleteHeroe(Long id);

}
