package com.andres.testspring.controller;

import com.andres.testspring.dto.PessoaDTO;
import com.andres.testspring.dto.PessoaRespostaDTO;
import com.andres.testspring.model.Pessoa;
import com.andres.testspring.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/pessoas")
@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaRespostaDTO> salvar(@Valid @RequestBody PessoaDTO pessoaDTO) {
        Pessoa p = pessoaService.save(pessoaDTO.transformaParaObjeto());
        return new ResponseEntity<>(PessoaRespostaDTO.transformaEmDTO(p), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PessoaRespostaDTO> listar() {

        return pessoaService
                .findAll()
                .stream()
                .map(PessoaRespostaDTO::transformaEmDTO)
                .collect(Collectors.toList());
    }
}
