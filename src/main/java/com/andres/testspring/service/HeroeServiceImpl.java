package com.andres.testspring.service;

import com.andres.testspring.model.Heroe;
import com.andres.testspring.repository.HeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeroeServiceImpl implements HeroeService {
    @Autowired
    private HeroeRepository heroeRepository;

    public Heroe saveHeroe(Heroe heroe){
        return heroeRepository.save(heroe);
    }

    @Override
    public List<Heroe> heroeList() {
        return heroeRepository.findAll();
    }

    @Override
    public Optional<Heroe> getHeroeById(Long id) {
        return heroeRepository.findById(id);
    }

    @Override
    public Heroe updateHeroe(Heroe heroe, Long id) {
        Heroe heroModel = heroeRepository.findById(id).get();
        heroModel.setName(heroe.getName());
        heroModel.setPowerStats(heroe.getPowerStats());
        return heroeRepository.save(heroModel);
    }

    @Override
    public void deleteHeroe(Long id) {
        heroeRepository.deleteById(id);
    }




}