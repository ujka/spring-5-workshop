package com.space.solartravel.repositories;

import com.space.solartravel.domain.Planet;
import com.space.solartravel.domain.SpaceShip;
import com.space.solartravel.domain.Travel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
class TravelRepositoryTest {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private SpaceShipRepository spaceShipRepository;

    @Autowired
    private TravelRepository testee;
    private Long savedTravelId;

    private final Date START_AT = new Date();

    @BeforeEach
    public void setUpData() {
        Planet planet = new Planet();
        planet.setName("Mercury");
        planet.setGravity(0.38);
        planet.setDistanceFromEarth(91691000L);
        planet.setOrderInSolarSystem(1);

        SpaceShip spaceShip = new SpaceShip();
        spaceShip.setName("Anna");
        spaceShip.setCapacity(100);
        spaceShip.setFuelCapacity(10);
        spaceShip.setLightSpeedUnits(1.01);
        spaceShip.setWeight(34000d);

        Travel travel = new Travel();
        travel.setStartedAt(new Date());
        travel.setPlanet(planet);
        travel.setSpaceShip(spaceShip);

        Travel savedTravel = testee.save(travel);
        this.savedTravelId = savedTravel.getId();
    }

    @Test
    public void findById_hasResultToReturn_readTravelWithPlanetAndShipById() {
        Travel travel = testee.getOne(savedTravelId);
        Planet planet = travel.getPlanet();
        SpaceShip spaceShip = travel.getSpaceShip();

        assertEquals(0, START_AT.compareTo(travel.getStartedAt()));
        assertNull(travel.getEndedAt());

        assertEquals("Mercury", planet.getName());
        assertEquals(0.38, planet.getGravity());
        assertEquals(91691000L, planet.getDistanceFromEarth());
        assertEquals(1, planet.getOrderInSolarSystem());

        assertEquals("Anna", spaceShip.getName());
        assertEquals(100, spaceShip.getCapacity());
        assertEquals(10, spaceShip.getFuelCapacity());
        assertEquals(1.01, spaceShip.getLightSpeedUnits());
        assertEquals(34000d, spaceShip.getWeight());
    }
}