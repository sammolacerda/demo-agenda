package com.example.agenda.application.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.agenda.application.service.ContatoService;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class ContatoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContatoService contatoService;

    @Test
    void shouldDeleteContatoById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/agenda/api/v1/contato/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

    }

    @Test
    void testGetContato() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/agenda/api/v1/contato/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
