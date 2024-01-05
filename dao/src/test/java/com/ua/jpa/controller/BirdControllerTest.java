package com.ua.jpa.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BirdControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllBirds() throws Exception {
        mockMvc.perform(get("/api/birds/all"))
               .andExpect(status().isOk());
    }

    @Test
    void testSaveBird() throws Exception {
        mockMvc.perform(post("/api/birds/add")
                                .contentType("Application/json")
                                .content("{\"name\":\"sparrow\",\"description\":\"gray\"}"))
               .andExpect(status().isOk());
    }

    @Test
    @Sql("/data.sql")
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testGetByName() throws Exception {
        mockMvc.perform(get("/api/birds/by/{name}", "sparrow"))
               .andExpect(status().isOk());
    }

    @Test
    void testUpdateBird() throws Exception {
        mockMvc.perform(put("/api/birds/update")
                                .contentType("Application/json")
                                .content("{\"id\":1,\"name\":\"sparrow\",\"description\":\"white\"}"))
               .andExpect(status().isOk());
    }

    @Test
    @Sql("/data.sql")
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testDeleteBird() throws Exception {
        mockMvc.perform(delete("/api/birds/delete/{id}", 1))
               .andExpect(status().isNoContent());
    }
}
