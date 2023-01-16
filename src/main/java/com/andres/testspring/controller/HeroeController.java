package com.andres.testspring.controller;

import com.andres.testspring.model.Heroe;
import com.andres.testspring.service.HeroeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/heroes")
@RestController
public class HeroeController {

    @Autowired
    private HeroeService heroeServiceImpl;

    @PostMapping
    public ResponseEntity heroe(@RequestBody Heroe heroe) {
        return new ResponseEntity(heroeServiceImpl.saveHeroe(heroe), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Heroe>> heroes() {
        return new ResponseEntity(heroeServiceImpl.heroeList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getHeroe(@PathVariable("id") Long id){
        return new ResponseEntity(heroeServiceImpl.getHeroeById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateHeroe(@RequestBody Heroe heroe, @PathVariable("id") Long id ){
        return new ResponseEntity(heroeServiceImpl.updateHeroe(heroe, id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam String name){
        return new ResponseEntity<>(heroeServiceImpl.searchHeroeByName(name), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity deleteHeroe(@PathVariable("id") Long id){
        heroeServiceImpl.deleteHeroe(id);
        return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
    }

}
