package com.space.solartravel.bootup;

import com.space.solartravel.domain.Astronaut;
import com.space.solartravel.domain.Gender;
import com.space.solartravel.domain.Planet;
import com.space.solartravel.domain.SpaceShip;
import com.space.solartravel.domain.Travel;
import com.space.solartravel.repositories.AstronautRepository;
import com.space.solartravel.repositories.PlanetRepository;
import com.space.solartravel.repositories.SpaceShipRepository;
import com.space.solartravel.repositories.TravelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Profile({"test"})
@Slf4j
public class TestDataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private PlanetRepository planetRepository;
    private SpaceShipRepository spaceShipRepository;
    private AstronautRepository astronautRepository;
    private TravelRepository travelRepository;

    public TestDataInitializer(PlanetRepository planetRepository, SpaceShipRepository spaceShipRepository, AstronautRepository astronautRepository, TravelRepository travelRepository) {
        this.planetRepository = planetRepository;
        this.spaceShipRepository = spaceShipRepository;
        this.astronautRepository = astronautRepository;
        this.travelRepository = travelRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("****** Initializing TEST data ******");
        initTestData();
    }

    private void initTestData() {
        // Planets
        Planet mercury = new Planet();
        mercury.setName("Mercury");
        mercury.setGravity(0.38);
        mercury.setDistanceFromEarth(91691000L);
        mercury.setOrderInSolarSystem(1);
        planetRepository.save(mercury);

        Planet venus = new Planet();
        venus.setName("Venus");
        venus.setGravity(0.91);
        venus.setDistanceFromEarth(41400000L);
        venus.setOrderInSolarSystem(2);
        planetRepository.save(venus);

        Planet mars = new Planet();
        mars.setName("Mars");
        mars.setGravity(0.38);
        mars.setDistanceFromEarth(119740000L);
        mars.setOrderInSolarSystem(4);
        planetRepository.save(mars);

        Planet jupiter = new Planet();
        jupiter.setName("Jupiter");
        jupiter.setGravity(2.34);
        jupiter.setDistanceFromEarth(670130000L);
        jupiter.setOrderInSolarSystem(5);
        planetRepository.save(jupiter);

        Planet saturn = new Planet();
        saturn.setName("Saturn");
        saturn.setGravity(0.93);
        saturn.setDistanceFromEarth(1275000000L);
        saturn.setOrderInSolarSystem(6);
        planetRepository.save(saturn);

        Planet uranus = new Planet();
        uranus.setName("Uranus");
        uranus.setGravity(0.92);
        uranus.setDistanceFromEarth(2723950000L);
        uranus.setOrderInSolarSystem(7);
        planetRepository.save(uranus);

        Planet neptune = new Planet();
        neptune.setName("Neptune");
        neptune.setGravity(1.12);
        neptune.setDistanceFromEarth(4351400000L);
        neptune.setOrderInSolarSystem(8);
        planetRepository.save(neptune);

        // SpaceShips
        SpaceShip spaceShipArtemis = new SpaceShip();
        spaceShipArtemis.setName("Artemis");
        spaceShipArtemis.setCapacity(10);
        spaceShipArtemis.setFuelCapacity(10);
        spaceShipArtemis.setLightSpeedUnits(1.01);
        spaceShipArtemis.setWeight(34000d);
        spaceShipRepository.save(spaceShipArtemis);

        SpaceShip spaceShipApollo = new SpaceShip();
        spaceShipApollo.setName("Apollo");
        spaceShipApollo.setCapacity(12);
        spaceShipApollo.setFuelCapacity(70);
        spaceShipApollo.setLightSpeedUnits(0.9);
        spaceShipApollo.setWeight(34000d);
        spaceShipRepository.save(spaceShipApollo);

        SpaceShip spaceShipHera = new SpaceShip();
        spaceShipHera.setName("Hera");
        spaceShipHera.setCapacity(30);
        spaceShipHera.setFuelCapacity(85);
        spaceShipHera.setLightSpeedUnits(1.2);
        spaceShipHera.setWeight(27000d);
        spaceShipRepository.save(spaceShipHera);

        SpaceShip spaceShipAphrodite = new SpaceShip();
        spaceShipAphrodite.setName("Aphrodite");
        spaceShipAphrodite.setCapacity(100);
        spaceShipAphrodite.setFuelCapacity(190);
        spaceShipAphrodite.setLightSpeedUnits(2.0);
        spaceShipAphrodite.setWeight(30000d);
        spaceShipRepository.save(spaceShipAphrodite);

        SpaceShip spaceShipPrometheus = new SpaceShip();
        spaceShipPrometheus.setName("Prometheus");
        spaceShipPrometheus.setCapacity(300);
        spaceShipPrometheus.setFuelCapacity(500);
        spaceShipPrometheus.setLightSpeedUnits(3.4);
        spaceShipPrometheus.setWeight(50000d);
        spaceShipRepository.save(spaceShipPrometheus);

        // Astronauts
        Astronaut janeDoe1 = new Astronaut();
        janeDoe1.setName("Jane Doe I");
        janeDoe1.setAge(27);
        janeDoe1.setWeight(62.0);
        janeDoe1.setEmail("jane.doe1@johndoe.moc");
        janeDoe1.setGender(Gender.FEMALE);
        astronautRepository.save(janeDoe1);

        Astronaut johnDoe1 = new Astronaut();
        johnDoe1.setName("John Doe I");
        johnDoe1.setAge(32);
        johnDoe1.setWeight(98.2);
        johnDoe1.setEmail("john.doe1@johndoe.moc");
        johnDoe1.setGender(Gender.MALE);
        astronautRepository.save(johnDoe1);

        Astronaut janeDoe2 = new Astronaut();
        janeDoe2.setName("Jane Doe II");
        janeDoe2.setAge(30);
        janeDoe2.setWeight(58.9);
        janeDoe2.setEmail("jane.doe2@johndoe.moc");
        janeDoe2.setGender(Gender.FEMALE);
        astronautRepository.save(janeDoe2);

        Astronaut johnDoe2 = new Astronaut();
        johnDoe2.setName("John Doe II");
        johnDoe2.setAge(41);
        johnDoe2.setWeight(89.1);
        johnDoe2.setEmail("john.doe2@johndoe.moc");
        johnDoe2.setGender(Gender.MALE);
        astronautRepository.save(johnDoe2);

        Astronaut janeDoe3 = new Astronaut();
        janeDoe3.setName("Jane Doe III");
        janeDoe3.setAge(19);
        janeDoe3.setWeight(53.1);
        janeDoe3.setEmail("jane.doe3@johndoe.moc");
        janeDoe3.setGender(Gender.FEMALE);
        astronautRepository.save(janeDoe3);

        Astronaut johnDoe3 = new Astronaut();
        johnDoe3.setName("John Doe III");
        johnDoe3.setAge(21);
        johnDoe3.setWeight(78.4);
        johnDoe3.setEmail("john.doe3@johndoe.moc");
        johnDoe3.setGender(Gender.MALE);
        astronautRepository.save(johnDoe3);

        Astronaut janeDoe4 = new Astronaut();
        janeDoe4.setName("Jane Doe IV");
        janeDoe4.setAge(25);
        janeDoe4.setWeight(60.0);
        janeDoe4.setEmail("jane.doe4@johndoe.moc");
        janeDoe4.setGender(Gender.FEMALE);
        astronautRepository.save(janeDoe4);

        Astronaut johnDoe4 = new Astronaut();
        johnDoe4.setName("John Doe IV");
        johnDoe4.setAge(56);
        johnDoe4.setWeight(76.1);
        johnDoe4.setEmail("john.doe4@johndoe.moc");
        johnDoe4.setGender(Gender.MALE);
        astronautRepository.save(johnDoe4);

        Astronaut janeDoe5 = new Astronaut();
        janeDoe5.setName("Jane Doe V");
        janeDoe5.setAge(24);
        janeDoe5.setWeight(58.7);
        janeDoe5.setEmail("jane.doe5@johndoe.moc");
        janeDoe5.setGender(Gender.FEMALE);
        astronautRepository.save(janeDoe5);

        Astronaut johnDoe5 = new Astronaut();
        johnDoe5.setName("John Doe V");
        johnDoe5.setAge(61);
        johnDoe5.setWeight(92.0);
        johnDoe5.setEmail("john.doe5@johndoe.moc");
        johnDoe5.setGender(Gender.MALE);
        astronautRepository.save(johnDoe5);

        Astronaut janeDoe6 = new Astronaut();
        janeDoe6.setName("Jane Doe VI");
        janeDoe6.setAge(43);
        janeDoe6.setWeight(53.8);
        janeDoe6.setEmail("jane.doe6@johndoe.moc");
        janeDoe6.setGender(Gender.FEMALE);
        astronautRepository.save(janeDoe6);

        // Assigning astronauts to the SpaceShip
        spaceShipArtemis.getAstronauts().add(janeDoe1);
        janeDoe1.setAssignedSpaceShip(spaceShipArtemis);
        spaceShipArtemis.getAstronauts().add(janeDoe2);
        janeDoe2.setAssignedSpaceShip(spaceShipArtemis);
        spaceShipArtemis.getAstronauts().add(janeDoe3);
        janeDoe3.setAssignedSpaceShip(spaceShipArtemis);
        spaceShipArtemis.getAstronauts().add(janeDoe6);
        janeDoe6.setAssignedSpaceShip(spaceShipArtemis);
        spaceShipArtemis.getAstronauts().add(johnDoe1);
        johnDoe1.setAssignedSpaceShip(spaceShipArtemis);
        spaceShipArtemis.getAstronauts().add(johnDoe2);
        johnDoe2.setAssignedSpaceShip(spaceShipArtemis);
        spaceShipArtemis.getAstronauts().add(johnDoe5);
        johnDoe5.setAssignedSpaceShip(spaceShipArtemis);
        spaceShipRepository.save(spaceShipArtemis);

        // Travel
        Travel travel = new Travel();
        travel.setStartedAt(new Date());
        venus.getTravels().add(travel);
        travel.setPlanet(venus);
        spaceShipArtemis.getTravels().add(travel);
        travel.setSpaceShip(spaceShipArtemis);
        travelRepository.save(travel);
    }
}
