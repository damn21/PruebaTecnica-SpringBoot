package com.andres.testspring.controller;

import com.andres.testspring.dto.HeroeDTO;
import com.andres.testspring.dto.HeroeResponseDTO;
import com.andres.testspring.model.Heroe;
import com.andres.testspring.service.HeroeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/heroes")
@RestController
public class HeroeController {

    @Autowired
    private HeroeService heroeService;

    //@PostMapping
    //public ResponseEntity<HeroeResponseDTO> salvar(@Valid @RequestBody HeroeDTO heroeDTO) {
      //  Heroe p = heroeService.save(heroeDTO.transformaParaObjeto());
        //return new ResponseEntity<>(HeroeResponseDTO.transformaEmDTO(p), HttpStatus.CREATED);
    //}

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String heroes(Model model) {
        model.addAttribute("heroes", heroeService.findAllHeroes());
        return "index";
    }
}
