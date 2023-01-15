package com.andres.testspring.service;

import com.andres.testspring.model.Heroe;

import java.util.List;
import java.util.Optional;

public interface HeroeService {
     Heroe saveHeroe(Heroe heroe);
     List<Heroe> heroeList();
     Optional<Heroe> getHeroeById(Long id);
     Heroe updateHeroe(Heroe heroe, Long id);

     void deleteHeroe(Long id);

}
