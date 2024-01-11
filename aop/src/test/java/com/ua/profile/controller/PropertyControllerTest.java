package com.ua.profile.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ua.profile.model.PropertyResponse;
import com.ua.profile.provider.PropertyResponseArgumentsProvider;
import com.ua.profile.service.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PropertyController.class)
class PropertyControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    @Qualifier("firstService")
    private PropertyService firstService;

    @Mock
    @Qualifier("secondService")
    private PropertyService secondService;

    @InjectMocks
    private PropertyController propertyController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @ParameterizedTest
    @ArgumentsSource(PropertyResponseArgumentsProvider.class)
    void testGetFirstProperties(Queue<PropertyResponse> responses) {
        when(firstService.getProperties()).thenReturn(responses);
        ResponseEntity<Queue<PropertyResponse>> response = propertyController.getFirstProperty();
        assertNotNull(responses, "Responses should not be null");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @ParameterizedTest
    @ArgumentsSource(PropertyResponseArgumentsProvider.class)
    void testPollSecondProperties(Queue<PropertyResponse> responses) {
        when(secondService.pollProperty()).thenReturn(responses.peek());
        ResponseEntity<PropertyResponse> response = propertyController.pollSecondProperty();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @ParameterizedTest
    @ArgumentsSource(PropertyResponseArgumentsProvider.class)
    void testCreateFirstProperties(Queue<PropertyResponse> responses) throws Exception {
        for (PropertyResponse expectedResponse : responses) {
            String port = expectedResponse.getPort();
            String name = expectedResponse.getName();
            when(firstService.addProperty(port, name)).thenReturn(expectedResponse);
            mockMvc.perform(post("/api/property/{port}/{name}", port, name)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(objectMapper.writeValueAsString(expectedResponse)))
                   .andExpect(status().isOk())
                   .andExpect(jsonPath("$.name").value(expectedResponse.getName()))
                   .andExpect(jsonPath("$.port").value(expectedResponse.getPort()));
        }
    }

    @ParameterizedTest
    @ArgumentsSource(PropertyResponseArgumentsProvider.class)
    void testGetFirstProperty(Queue<PropertyResponse> responses) throws Exception {
        when(firstService.getProperties()).thenReturn(responses);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/property/dev")
                                              .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].profile").exists());
    }

    @ParameterizedTest
    @ArgumentsSource(PropertyResponseArgumentsProvider.class)
    void testGetSecondProperty(Queue<PropertyResponse> responses) throws Exception {
        when(secondService.getProperties()).thenReturn(responses);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/property/prod")
                                              .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].profile").exists());
    }

    @ParameterizedTest
    @ArgumentsSource(PropertyResponseArgumentsProvider.class)
    void testCreateFirstProperty(Queue<PropertyResponse> responses) throws Exception {
        while (!responses.isEmpty()) {
            PropertyResponse response = responses.poll();
            when(firstService.addProperty(response.getPort(), response.getName())).thenReturn(
                    response);
            mockMvc.perform(post("/api/property/" + response.getPort() + "/" + response.getName())
                                                  .contentType(MediaType.APPLICATION_JSON)
                                                  .content(objectMapper.writeValueAsString(
                                                          response)))
                   .andExpect(status().isOk())
                   .andExpect(jsonPath("$.profile").exists());
        }
    }

    @ParameterizedTest
    @ArgumentsSource(PropertyResponseArgumentsProvider.class)
    void testPollSecondProperty(Queue<PropertyResponse> responses) throws Exception {
        while (!responses.isEmpty()) {
            PropertyResponse response = responses.poll();
            when(secondService.pollProperty()).thenReturn(response);
            mockMvc.perform(MockMvcRequestBuilders.get("/api/property/prod/port")
                                                  .contentType(MediaType.APPLICATION_JSON))
                   .andExpect(status().isOk())
                   .andExpect(jsonPath("$.profile").exists());
        }
    }
}
