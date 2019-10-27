package com.space.solartravel.repositories;

import com.space.solartravel.domain.Planet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository testee;
    private Long savedPlanetId;

    @BeforeEach
    public void setUpData(){
        Planet planet = new Planet();
        planet.setName("Mercury");
        planet.setGravity(0.38);
        planet.setDistanceFromEarth(91691000L);
        planet.setOrderInSolarSystem(1);

        Planet savedPlanet = testee.save(planet);
        this.savedPlanetId = savedPlanet.getId();
    }

    @Test
    public void findById_hasResultToReturn_readPlanetById() {
        Planet planet = testee.getOne(savedPlanetId);
        assertEquals("Mercury", planet.getName());
        assertEquals(0.38, planet.getGravity());
        assertEquals(91691000L, planet.getDistanceFromEarth());
        assertEquals(1, planet.getOrderInSolarSystem());
    }

    @Test
    public void updateExisting_hasResultToReturn_updatedPlanetById() {
        Planet planet = testee.getOne(savedPlanetId);
        assertEquals("Mercury", planet.getName());
        assertEquals(0.38, planet.getGravity());
        assertEquals(91691000L, planet.getDistanceFromEarth());
        assertEquals(1, planet.getOrderInSolarSystem());

        planet.setName("Venus");
        planet.setGravity(0.91);
        planet.setDistanceFromEarth(41400000L);
        planet.setOrderInSolarSystem(2);

        Planet updatedPlanet = testee.save(planet);

        assertEquals("Venus", updatedPlanet.getName());
        assertEquals(0.91, updatedPlanet.getGravity());
        assertEquals(41400000L, updatedPlanet.getDistanceFromEarth());
        assertEquals(2, updatedPlanet.getOrderInSolarSystem());
    }

    @Test
    public void deleteExisting_hasResultToReturn_updatedPlanetById() {
        Planet planet = testee.getOne(savedPlanetId);
        assertEquals("Mercury", planet.getName());
        assertEquals(0.38, planet.getGravity());
        assertEquals(91691000L, planet.getDistanceFromEarth());
        assertEquals(1, planet.getOrderInSolarSystem());

        testee.delete(planet);

        Optional<Planet> deletedPlanet = testee.findById(savedPlanetId);
        assertFalse(deletedPlanet.isPresent());
    }
}