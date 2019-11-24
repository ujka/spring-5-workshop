package com.space.solartravel.controllers;

import com.space.solartravel.domain.Astronaut;
import com.space.solartravel.services.AstronautService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class AstronautControllerTest {

    @Mock
    AstronautService astronautService;

    @InjectMocks
    AstronautController testee;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(testee).build();
    }

    @Test
    void signup() throws Exception {
        mockMvc.perform(get("/signup"))
                .andExpect(status().isOk())
                .andExpect(view().name("astronaut"))
                .andExpect(model().attributeExists("astronaut"));
    }

    @Test
    void singMeUp() throws Exception {
        Astronaut astronaut = new Astronaut();
        astronaut.setId(1L);
        when(astronautService.save(any(Astronaut.class))).thenReturn(astronaut);

        mockMvc.perform(post("/saveAstronaut")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "name")
                        .param("age","23")
                        .param("weight", "67")
                        .param("gender", "MALE")
                        .param("email", "email"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/astronaut/" + astronaut.getId()));
    }

    @Test
    void getAstronaut() throws Exception {
        Long searchId = 34L;

        Astronaut astronaut = new Astronaut();
        astronaut.setId(34L);
        astronaut.setName("testee");

        when(astronautService.findById(searchId)).thenReturn(astronaut);

        mockMvc.perform(get("/astronaut/"+ searchId))
                .andExpect(status().isOk())
                .andExpect(view().name("astronaut"))
                .andExpect(model().attribute("astronaut", astronaut));
    }

    @Test
    void updateAstronaut() throws Exception {
        Long searchId = 34L;

        Astronaut astronaut = new Astronaut();
        astronaut.setId(34L);
        astronaut.setName("testee");

        when(astronautService.findById(searchId)).thenReturn(astronaut);

        mockMvc.perform(get("/updateAstronaut/"+ searchId))
                .andExpect(status().isOk())
                .andExpect(view().name("update_astronaut"))
                .andExpect(model().attribute("astronaut", astronaut));
    }
}