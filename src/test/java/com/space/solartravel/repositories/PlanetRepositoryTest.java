package com.space.solartravel.repositories;

import com.space.solartravel.domain.Planet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void findByTravelRange_hasResultsToReturn_returnsPlanetsFittingCriteria() {
        Planet venus = new Planet();
        venus.setName("Venus");
        venus.setGravity(0.91);
        venus.setDistanceFromEarth(41400000L);
        venus.setOrderInSolarSystem(2);
        testee.save(venus);

        Planet mars = new Planet();
        mars.setName("Mars");
        mars.setGravity(0.38);
        mars.setDistanceFromEarth(119740000L);
        mars.setOrderInSolarSystem(4);
        testee.save(mars);

        List<Planet> planetsInRange = testee.findByDistanceInTravelRange(100000000L);
        assertEquals(2, planetsInRange.size());
        assertTrue(planetsInRange.contains(venus));
        assertFalse(planetsInRange.contains(mars));
    }
}