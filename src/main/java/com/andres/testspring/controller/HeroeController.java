package com.andres.testspring.controller;

import com.andres.testspring.model.Heroe;
import com.andres.testspring.repository.HeroeRepository;
import com.andres.testspring.service.HeroeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/heroes")
@RestController
public class HeroeController {

    @Autowired
    private HeroeService heroeService;

    @PostMapping
    public ResponseEntity heroe(@RequestBody Heroe heroe) {
        return new ResponseEntity(heroeService.createHeroe(heroe), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Heroe>> heroes() {
        return new ResponseEntity(heroeService.findAllHeroes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getHeroe(@PathVariable("id") Long id){
        return new ResponseEntity(heroeService.findHeroeById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateHeroe(@PathVariable("id") Long id, @RequestBody Heroe heroe){
        return new ResponseEntity(heroeService.updateHeroe(id,heroe), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity deleteHeroe(@PathVariable("id") Long id){
        boolean response = heroeService.deleteHeroeById(id);

        if (!response){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
