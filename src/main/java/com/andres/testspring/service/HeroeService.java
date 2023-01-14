package com.andres.testspring.service;

import com.andres.testspring.model.Heroe;
import com.andres.testspring.repository.HeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class HeroeService {
    @Autowired
    private HeroeRepository heroeRepository;

    public Heroe createHeroe(Heroe heroe){
        return heroeRepository.save(heroe);
    }

    public ArrayList<Heroe> findAllHeroes(){
        return (ArrayList<Heroe>) heroeRepository.findAll();
    }

    public Optional<Heroe> findHeroeById(Long id){
        return heroeRepository.findById(id);
    }

    public  Heroe updateHeroe(Long id, Heroe heroe){
       Heroe heroModel = heroeRepository.findById(id).get();
       heroModel.setName(heroe.getName());
       heroModel.setPowerStats(heroe.getPowerStats());
       return heroeRepository.save(heroModel);
    }

    public boolean deleteHeroeById(Long id){
        try {
            heroeRepository.deleteById(id);
            return true;

        }catch (Exception err){
            return false;
        }
    }

}
