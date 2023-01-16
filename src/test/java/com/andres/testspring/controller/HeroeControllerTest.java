package com.andres.testspring.controller;

import com.andres.testspring.auth.jwtUtils.TokenManager;
import com.andres.testspring.model.Heroe;
import com.andres.testspring.service.JwtUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.andres.testspring.repository.HeroeRepository;
import com.andres.testspring.service.HeroeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HeroeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private HeroeService heroeServiceImpl;

    @Autowired
    private HeroeRepository heroeRepository;

    @BeforeEach
    void setup() {
        heroeRepository.deleteAll();
    }
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private JwtUserDetailsService userDetailsService;


    @Test
    void heroe() throws Exception {
        Heroe heroe = new Heroe(1l,"Batman", "Bruce Wayne",
                "Interrogation, Peak Human Conditioning, Martial Arts Master, Weapons Master");

        UserDetails userDetails = userDetailsService.loadUserByUsername("admin");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+tokenManager.generateJwtToken(userDetails));

        mockMvc.perform(
                post("/api/v1/heroes").contentType("application/json;charset=UTF-8")
                        .headers(headers)
                        .content(objectMapper.writeValueAsString(heroe)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}