package com.ua.jpa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ua.jpa.model.Bird;
import com.ua.jpa.service.BirdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class BirdControllerClientTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BirdService service;

    List<Bird> mockBirds = Arrays.asList(
            new Bird(1L, "Sparrow", "small"),
            new Bird(2L, "Eagle", "large"));

    @Test
    @Sql("/data.sql")
    void getAllBirds() throws Exception {
        String expectedJson = mockBirds.stream()
                                       .map(Object::toString)
                                       .collect(Collectors.joining(",", "[", "]"));
        when(service.getAll()).thenReturn(mockBirds);
        mockMvc.perform(get("/api/birds/all")
                                .contentType(APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().string(expectedJson))
               .andDo(MockMvcResultHandlers.print());
        verify(service, times(1)).getAll();
    }

    @Test
    @Sql("/data.sql")
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void shouldReturnBirdById() throws Exception {
        Long birdId = 1L;
        when(service.getById(birdId)).thenReturn(ok(mockBirds.get(0)));
        mockMvc.perform(get("/api/birds/{id}", birdId))
               .andExpect(status().isOk())
               .andExpect(content().string(mockBirds.get(0).toString()));
        verify(service, times(1)).getById(birdId);
    }

    @Test
    void shouldReturnBirdsByName() throws Exception {
        String birdName = "Sparrow";
        when(service.getByName(birdName)).thenReturn(ok(singletonList(mockBirds.get(0))));
        mockMvc.perform(get("/api/birds/by/{name}", birdName)
                                .contentType(APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().string(singletonList(mockBirds.get(0)).toString()));
        verify(service, times(1)).getByName(birdName);
    }

    @Test
    void shouldSaveBird() throws Exception {
        Bird birdToSave = new Bird(null, "Bird", "New");
        Bird savedBird = new Bird(1L,  "Bird", "New");
        when(service.create(birdToSave)).thenReturn(savedBird);
        mockMvc.perform(post("/api/birds/add")
                                .contentType(APPLICATION_JSON)
                                .content(getJson(birdToSave)))
               .andExpect(status().isOk())
               .andExpect(content().string(savedBird.toString()));
        verify(service, times(1)).create(birdToSave);
    }

    @Test
    void shouldUpdateBird() throws Exception {
        Bird birdToUpdate = new Bird(1L, "Bird", "Updated");
        when(service.update(birdToUpdate)).thenReturn(ok(birdToUpdate));
        mockMvc.perform(put("/api/birds/update")
                                .contentType(APPLICATION_JSON)
                                .content(getJson(birdToUpdate)))
               .andExpect(status().isOk())
               .andExpect(content().string(birdToUpdate.toString()));
        verify(service, times(1)).update(birdToUpdate);
    }

    @Test
    void shouldNotFindBirdById() throws Exception {
        Long id = 1L;
        when(service.getById(id)).thenReturn(notFound().build());
        mockMvc.perform(get("/api/birds/{id}", id)
                                .contentType(APPLICATION_JSON))
               .andExpect(status().isNotFound());
    }

    @Test
    void shouldDeleteBird() throws Exception {
        Long birdId = 1L;
        mockMvc.perform(delete("/api/birds/delete/{id}", birdId))
               .andExpect(status().isOk());
        verify(service, times(1)).deleteById(birdId);
    }

    @Test
    void shouldNotFindBirdsByName() throws Exception {
        String name = "NonExistentBird";
        when(service.getByName(name)).thenReturn(notFound().build());
        mockMvc.perform(get("/api/birds/by/{name}", name)
                                .contentType(APPLICATION_JSON))
               .andExpect(status().isNotFound());
    }

    @Test
    void shouldNotUpdateNonExistentBird() throws Exception {
        Bird birdToUpdate = new Bird(1L, "Bird", "Updated");
        when(service.update(birdToUpdate)).thenReturn(ResponseEntity.notFound().build());
        mockMvc.perform(put("/api/birds/update")
                                .contentType(APPLICATION_JSON)
                                .content(getJson(birdToUpdate)))
               .andExpect(status().isNotFound());
    }

    @Test
    void shouldNotDeleteNonExistentBird() throws Exception {
        Long id = 1L;
        when(service.deleteById(id)).thenReturn(ResponseEntity.notFound().build());
        mockMvc.perform(delete("/api/birds/delete/{id}", id)
                                .contentType(APPLICATION_JSON))
               .andExpect(status().isNotFound());
    }

    private static String getJson(Bird birdToSave)
            throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(birdToSave);
    }
}
