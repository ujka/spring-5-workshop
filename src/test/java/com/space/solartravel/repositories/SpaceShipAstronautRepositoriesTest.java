package com.space.solartravel.repositories;

import com.space.solartravel.domain.Astronaut;
import com.space.solartravel.domain.SpaceShip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class SpaceShipAstronautRepositoriesTest {

    @Autowired
    private AstronautRepository astronautRepository;
    private Long savedAstronautId;

    @Autowired
    private SpaceShipRepository spaceShipRepository;
    private Long savedSpaceShipId;

    @BeforeEach
    public void setUpData(){
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.setName("Anna");
        spaceShip.setCapacity(100);
        spaceShip.setFuelCapacity(10);
        spaceShip.setLightSpeedUnits(1.01);
        spaceShip.setWeight(34000d);

        Astronaut astronaut = new Astronaut();
        astronaut.setName("John Doe");
        astronaut.setAge(32);
        astronaut.setWeight(98.2);
        astronaut.setEmail("john.doe@johndoe.moc");
        astronaut.setAssignedSpaceShip(spaceShip);
        spaceShip.getAstronauts().add(astronaut);

        SpaceShip savedSpaceShip = spaceShipRepository.save(spaceShip);
        this.savedSpaceShipId = savedSpaceShip.getId();
    }

    @Test
    public void saveSpaceShipWithAstronaut_astrounatProvided_relationshipSaved() {
        SpaceShip spaceShip = spaceShipRepository.getOne(savedSpaceShipId);
        Astronaut astronaut = spaceShip.getAstronauts().iterator().next();
        assertEquals("John Doe", astronaut.getName());
        assertEquals(32, astronaut.getAge());
        assertEquals(98.2, astronaut.getWeight());
        assertEquals("john.doe@johndoe.moc", astronaut.getEmail());

        SpaceShip assignedSpaceShip = astronaut.getAssignedSpaceShip();
        assertEquals(spaceShip, assignedSpaceShip);

        assertEquals("Anna", assignedSpaceShip.getName());
        assertEquals(100, assignedSpaceShip.getCapacity());
        assertEquals(10, assignedSpaceShip.getFuelCapacity());
        assertEquals(1.01, assignedSpaceShip.getLightSpeedUnits());
        assertEquals(34000d, assignedSpaceShip.getWeight());
    }
}
