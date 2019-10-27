package com.space.solartravel.repositories;

import com.space.solartravel.domain.Astronaut;
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
class AstronautRepositoryTest {

    @Autowired
    private AstronautRepository testee;
    private Long savedAstronautId;


    @BeforeEach
    public void setUpData(){
        Astronaut astronaut = new Astronaut();
        astronaut.setName("John Doe");
        astronaut.setAge(32);
        astronaut.setWeight(98.2);
        astronaut.setEmail("john.doe@johndoe.moc");

        Astronaut saveAstronaut = testee.save(astronaut);
        this.savedAstronautId = saveAstronaut.getId();
    }

    @Test
    public void findById_hasResultToReturn_readAstronautById() {
        Astronaut astronaut = testee.findById(savedAstronautId).get();
        assertEquals("John Doe", astronaut.getName());
        assertEquals(32, astronaut.getAge());
        assertEquals(98.2, astronaut.getWeight());
        assertEquals("john.doe@johndoe.moc", astronaut.getEmail());
    }

    @Test
    public void updateExisting_hasResultToReturn_readAstronautById() {
        Astronaut astronaut = testee.findById(savedAstronautId).get();
        assertEquals("John Doe", astronaut.getName());
        assertEquals(32, astronaut.getAge());
        assertEquals(98.2, astronaut.getWeight());
        assertEquals("john.doe@johndoe.moc", astronaut.getEmail());
        astronaut.setAge(33);
        astronaut.setWeight(90.1);

        Astronaut updatedAstronaut = testee.save(astronaut);

        assertEquals("John Doe", updatedAstronaut.getName());
        assertEquals(33, updatedAstronaut.getAge());
        assertEquals(90.1, updatedAstronaut.getWeight());
        assertEquals("john.doe@johndoe.moc", updatedAstronaut.getEmail());
    }

    @Test
    public void deleteExisting_hasResultToReturn_astronautDeleted() {
        Astronaut astronaut = testee.findById(savedAstronautId).get();
        assertEquals("John Doe", astronaut.getName());
        assertEquals(32, astronaut.getAge());
        assertEquals(98.2, astronaut.getWeight());
        assertEquals("john.doe@johndoe.moc", astronaut.getEmail());
        astronaut.setAge(33);
        astronaut.setWeight(90.1);

        testee.deleteById(savedAstronautId);

        Optional<Astronaut> deletedAstronaut = testee.findById(savedAstronautId);
        assertFalse(deletedAstronaut.isPresent());
    }
}