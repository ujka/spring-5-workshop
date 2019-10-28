package com.space.solartravel.repositories;

import com.space.solartravel.domain.Astronaut;
import com.space.solartravel.domain.SpaceShip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class SpaceShipAstronautRepositoriesTest {

    @Autowired
    private SpaceShipRepository spaceShipRepository;
    private Long savedSpaceShipId;

    @Autowired
    private AstronautRepository astronautRepository;
    private SpaceShip spaceShip;

    @BeforeEach
    public void setUpData(){
        spaceShip = new SpaceShip();
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

        Astronaut astronaut2 = new Astronaut();
        astronaut2.setName("John Doe 2");
        astronaut2.setAge(28);
        astronaut2.setWeight(67.9);
        astronaut2.setEmail("john.doe2@johndoe.moc");
        astronaut2.setAssignedSpaceShip(spaceShip);
        spaceShip.getAstronauts().add(astronaut2);

        SpaceShip savedSpaceShip = spaceShipRepository.save(spaceShip);
        this.savedSpaceShipId = savedSpaceShip.getId();

        Astronaut astronaut3 = new Astronaut();
        astronaut3.setName("John Doe 3");
        astronaut3.setAge(32);
        astronaut3.setWeight(93.2);
        astronaut3.setEmail("john.doe3@johndoe.moc");

        astronautRepository.save(astronaut3);
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

    @Test
    public void deleteSpaceShipById_hasAssignedAstronauts_astronautNotDeleted() {
        SpaceShip spaceShip = spaceShipRepository.getOne(savedSpaceShipId);
        Astronaut astronaut1 = spaceShip.getAstronauts().iterator().next();

        spaceShipRepository.deleteById(savedSpaceShipId);

        assertNotNull(astronautRepository.getOne(astronaut1.getId()));
    }

    @Test
    public void findBySpaceShip_hasAstronautsAssigned_returnsAllAssignedAstronauts() {
        SpaceShip spaceShip = spaceShipRepository.getOne(savedSpaceShipId);
        List<Astronaut> astronauts = astronautRepository.findByAssignedSpaceShip(spaceShip);
        assertEquals(spaceShip.getAstronauts().size(), astronauts.size());
    }

    @Test
    public void findAllUnassigned_hasUnassignedAstronauts_returnsAllUnassigned() {
        List<Astronaut> unasignedAstronauts = astronautRepository.findAllUnassigned();
        assertEquals(1, unasignedAstronauts.size());
        Astronaut astronaut = unasignedAstronauts.iterator().next();
        assertEquals("John Doe 3", astronaut.getName());
        assertEquals(32, astronaut.getAge());
        assertEquals(93.2, astronaut.getWeight());
        assertEquals("john.doe3@johndoe.moc", astronaut.getEmail());

    }
}
