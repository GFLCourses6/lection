package com.ua.jpa.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebIntegrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllRequestIntegration()
            throws Exception {
        mockMvc.perform(get("/api/web").contentType(MediaType.APPLICATION_JSON))
               .andDo(MockMvcResultHandlers.print())
               .andExpect(status().isOk());
    }

    @Test
    void testGetRequestIntegration()
            throws Exception {
        mockMvc.perform(get("/api/web").param("role", "ADMIN")
                                       .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }

    @Test
    void testPostIntegration()
            throws Exception {
        mockMvc.perform(post("/api/web")
                                .content("{\"name\":\"John Doe\",\"age\":30}")
                                .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }

    @Test
    void testPostWebIntegration()
            throws Exception {
        mockMvc.perform(post("/api/web/integration")
                                .content("[{\"name\":\"John Doe\",\"age\":30},{\"name\":\"John Doe\",\"age\":25}]")
                                .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }

    @Test
    void testPutIntegration()
            throws Exception {
        mockMvc.perform(put("/api/web").content(
                "{\"name\":\"Updated John Doe\",\"age\":35}")
                                       .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }

    @Test
    void testDeleteAllIntegration()
            throws Exception {
        mockMvc.perform(delete("/api/web").contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().is2xxSuccessful());
    }
}
