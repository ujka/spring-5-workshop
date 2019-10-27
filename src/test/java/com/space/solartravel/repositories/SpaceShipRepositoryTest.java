package com.space.solartravel.repositories;

import com.space.solartravel.domain.SpaceShip;
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
class SpaceShipRepositoryTest {

    @Autowired
    private SpaceShipRepository testee;
    private Long savedSpaceShipId;

    @BeforeEach
    public void setUpData(){
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.setName("Anna");
        spaceShip.setCapacity(100);
        spaceShip.setFuelCapacity(10);
        spaceShip.setLightSpeedUnits(1.01);
        spaceShip.setWeight(34000d);

        SpaceShip savedSpaceShip = testee.save(spaceShip);
        this.savedSpaceShipId = savedSpaceShip.getId();

    }

    @Test
    public void findById_hasResultToReturn_readPlanetById() {
        SpaceShip spaceShip = testee.getOne(savedSpaceShipId);
        assertEquals("Anna", spaceShip.getName());
        assertEquals(100, spaceShip.getCapacity());
        assertEquals(10, spaceShip.getFuelCapacity());
        assertEquals(1.01, spaceShip.getLightSpeedUnits());
        assertEquals(34000d, spaceShip.getWeight());
    }

    @Test
    public void updateExisting_hasResultToReturn_updatedPlanetById() {
        SpaceShip spaceShip = testee.getOne(savedSpaceShipId);
        assertEquals("Anna", spaceShip.getName());
        assertEquals(100, spaceShip.getCapacity());
        assertEquals(10, spaceShip.getFuelCapacity());
        assertEquals(1.01, spaceShip.getLightSpeedUnits());
        assertEquals(34000d, spaceShip.getWeight());

        spaceShip.setWeight(30000d);
        spaceShip.setName("Anna II");
        spaceShip.setLightSpeedUnits(1.18);

        SpaceShip updatedSpaceShip = testee.save(spaceShip);

        assertEquals("Anna II", updatedSpaceShip.getName());
        assertEquals(100, updatedSpaceShip.getCapacity());
        assertEquals(10, updatedSpaceShip.getFuelCapacity());
        assertEquals(1.18, updatedSpaceShip.getLightSpeedUnits());
        assertEquals(30000d, updatedSpaceShip.getWeight());
    }

    @Test
    public void deleteExisting_hasResultToReturn_updatedPlanetById() {
        SpaceShip spaceShip = testee.getOne(savedSpaceShipId);
        assertEquals("Anna", spaceShip.getName());
        assertEquals(100, spaceShip.getCapacity());
        assertEquals(10, spaceShip.getFuelCapacity());
        assertEquals(1.01, spaceShip.getLightSpeedUnits());
        assertEquals(34000d, spaceShip.getWeight());

        testee.delete(spaceShip);

        Optional<SpaceShip> deletedSpaceShip = testee.findById(savedSpaceShipId);
        assertFalse(deletedSpaceShip.isPresent());
    }

}