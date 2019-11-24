package com.space.solartravel.controllers;

import com.space.solartravel.domain.Astronaut;
import com.space.solartravel.domain.Gender;
import com.space.solartravel.domain.SpaceShip;
import com.space.solartravel.services.AstronautService;
import com.space.solartravel.services.PlanetService;
import com.space.solartravel.services.SpaceShipService;
import com.space.solartravel.services.TravelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(SpaceShipController.class)
class SpaceShipControllerWebMvcTest {

    @MockBean
    SpaceShipService spaceShipService;

    @MockBean
    AstronautService astronautService;

    @MockBean
    TravelService travelService;

    @MockBean
    PlanetService planetService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getSpaceShip() throws Exception {
        SpaceShip spaceShipArtemis = new SpaceShip();
        spaceShipArtemis.setId(1L);
        spaceShipArtemis.setName("Artemis");
        spaceShipArtemis.setCapacity(10);
        spaceShipArtemis.setFuelCapacity(10);
        spaceShipArtemis.setLightSpeedUnits(1.01);
        spaceShipArtemis.setWeight(34000d);

        Astronaut janeDoe1 = new Astronaut();
        janeDoe1.setId(1L);
        janeDoe1.setName("Jane Doe I");
        janeDoe1.setAge(27);
        janeDoe1.setWeight(62.0);
        janeDoe1.setEmail("jane.doe1@johndoe.moc");
        janeDoe1.setGender(Gender.FEMALE);

        Astronaut janeDoe2 = new Astronaut();
        janeDoe2.setId(2L);
        janeDoe2.setName("Jane Doe II");
        janeDoe2.setAge(30);
        janeDoe2.setWeight(58.9);
        janeDoe2.setEmail("jane.doe2@johndoe.moc");
        janeDoe2.setGender(Gender.FEMALE);

        spaceShipArtemis.getAstronauts().add(janeDoe1);
        janeDoe1.setAssignedSpaceShip(spaceShipArtemis);
        spaceShipArtemis.getAstronauts().add(janeDoe2);
        janeDoe2.setAssignedSpaceShip(spaceShipArtemis);

        when(spaceShipService.findById(anyLong())).thenReturn(spaceShipArtemis);
        Set<Astronaut> astronauts = spaceShipArtemis.getAstronauts();
        when(astronautService.findAllBySpaceShip(spaceShipArtemis)).thenReturn(List.copyOf(astronauts));
        when(astronautService.findAllUnassigned()).thenReturn(Collections.emptyList());
        when(travelService.findActiveTravelForSpaceShip(spaceShipArtemis)).thenReturn(null);

        mockMvc.perform(get("/spaceShip/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("spaceship"))
                .andExpect(model().attribute("spaceShip", spaceShipArtemis))
                .andExpect(model().attribute("assignedAstronauts", List.copyOf(astronauts)))
                .andExpect(model().attributeDoesNotExist("activeTravel"))
                .andExpect(model().attribute("availableAstronauts", Collections.emptyList()));
    }

    @Test
    void assignToShip() throws Exception {
        Long shipId = 10L;
        Long astronautId = 15L;

        SpaceShip spaceShipArtemis = new SpaceShip();
        spaceShipArtemis.setId(shipId);
        spaceShipArtemis.setName("Artemis");
        spaceShipArtemis.setCapacity(10);
        spaceShipArtemis.setFuelCapacity(10);
        spaceShipArtemis.setLightSpeedUnits(1.01);
        spaceShipArtemis.setWeight(34000d);

        Astronaut janeDoe1 = new Astronaut();
        janeDoe1.setId(astronautId);
        janeDoe1.setName("Jane Doe I");
        janeDoe1.setAge(27);
        janeDoe1.setWeight(62.0);
        janeDoe1.setEmail("jane.doe1@johndoe.moc");
        janeDoe1.setGender(Gender.FEMALE);

        when(spaceShipService.findById(shipId)).thenReturn(spaceShipArtemis);
        when(astronautService.findById(astronautId)).thenReturn(janeDoe1);

        mockMvc.perform(post("/assignToShip/{spaceShipId}/{astronautId}", shipId, astronautId))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/spaceShip/"+shipId));
        verify(spaceShipService).assignAstronautToTheShip(janeDoe1, spaceShipArtemis);
    }

    @Test
    void newSpaceShip() throws Exception {
        mockMvc.perform(get("/craftSpaceShip"))
                .andExpect(status().isOk())
                .andExpect(view().name("spaceShip"))
                .andExpect(model().attributeExists("spaceShip"));
    }

    @Test
    void saveSpaceShip() throws Exception {
        Long spaceShipId =1L;

        SpaceShip spaceShipArtemis = new SpaceShip();
        spaceShipArtemis.setId(spaceShipId);
        spaceShipArtemis.setName("Artemis");
        spaceShipArtemis.setCapacity(10);
        spaceShipArtemis.setFuelCapacity(10);
        spaceShipArtemis.setLightSpeedUnits(1.01);
        spaceShipArtemis.setWeight(34000d);

        when(spaceShipService.save(any(SpaceShip.class))).thenReturn(spaceShipArtemis);

        mockMvc.perform(post("/saveSpaceShip")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "name")
                .param("lightSpeedUnits","1.01")
                .param("weight", "67")
                .param("capacity", "10")
                .param("fuelCapacity", "10"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/spaceShip/" + spaceShipId));
    }
}