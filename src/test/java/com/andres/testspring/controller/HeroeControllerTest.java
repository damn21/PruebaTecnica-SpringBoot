package com.andres.testspring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.andres.testspring.dto.HeroeDTO;
import com.andres.testspring.repository.HeroeRepository;
import com.andres.testspring.service.HeroeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest // Auto configuração das classes e configurações da aplicação
@AutoConfigureMockMvc // Auto configura o Spring MockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Cria uma instância por teste
class HeroeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private HeroeService heroeService;

    @Autowired
    private HeroeRepository heroeRepository;

    //  Data fictícia
    private LocalDate localDate = LocalDate.of(2000, 1, 1);

    @BeforeEach
    void setup() {
        heroeRepository.deleteAll();
    }

    @Test
    void salvar() throws Exception {
        HeroeDTO heroeDTO = new HeroeDTO("Teste");

        mockMvc.perform(
                post("/pessoas").contentType("application/json;charset=UTF-8").content(objectMapper.writeValueAsString(heroeDTO)))
                .andDo(print()) // Opcional
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    //  Nome
    @Test
    void salvarNomeInvalidoTest() throws Exception {
        testarNome(null, "O nome não pode ser vazio!");
        testarNome("aa", "O nome precisa ter entre 3 e 40 caracteres!");
    }

    void testarNome(String nome, String respostaEsperada) throws Exception {
        HeroeDTO heroeDTO = new HeroeDTO(nome);

        mockMvc.perform(
                post("/pessoas").contentType("application/json;charset=UTF-8").content(objectMapper.writeValueAsString(heroeDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.nome").value(respostaEsperada))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    //  Email
    @Test
    void salvarEmailInvalido() throws Exception {
        // DRY - pessoa válida no banco
        salvar();

        testarEmail(null, "E-mail precisa ser fornecido!");
        testarEmail("Teste", "E-mail inválido!");
        testarEmail("Teste@@gmail.com", "E-mail inválido!");
        testarEmail("Teste@gmail.com", "Email já cadastrado!");
    }

    void testarEmail(String email, String respostaEsperada) throws Exception {
        HeroeDTO heroeDTO = new HeroeDTO("aaa");

        mockMvc.perform(
                post("/pessoas").contentType("application/json;charset=UTF-8").content(objectMapper.writeValueAsString(heroeDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.email").value(respostaEsperada))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    //  CPF
    // Nota: Como setamos o ignoreRepeated = true na classe PessoaDTO
    // nós podemos registrar CPFs com números repetidos como "11111111111".

    @Test
    void salvarCPFInvalido() throws Exception {
        // DRY - pessoa válida no banco
        salvar();

        testarCPF(null, "CPF não pode ser vazio!");
        testarCPF("3", "CPF Inválido!"); // Caelum Stella
        testarCPF("34274324832487387", "CPF Inválido!"); // Caelum Stella
        testarCPF("11111111111", "CPF já cadastrado!");
    }

    void testarCPF(String cpf, String respostaEsperada) throws Exception {
        HeroeDTO heroeDTO = new HeroeDTO("aaa");

        mockMvc.perform(
                post("/pessoas").contentType("application/json;charset=UTF-8").content(objectMapper.writeValueAsString(heroeDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.cpf").value(respostaEsperada))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}