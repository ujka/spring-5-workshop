package com.space.solartravel.services.gravity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = GravityTestConfiguration.class)
@TestPropertySource("classpath:application.properties")
class GravityServiceImplTest {

    @Autowired
    @Qualifier("saturnGravityService")
    private GravityService saturnGravityService;

    @Autowired
    @Qualifier("uranusGravityService")
    private GravityService uranusGravityService;

    @Autowired
    @Qualifier("neptuneGravityService")
    private GravityService neptuneGravityService;

    @Test
    void calculateForceWeight_weightProvided_returnsTheCorrectWeightForSaturn() {
        double weight = 98.3;
        double expectedWeight = 91.419;
        double resultWeight = saturnGravityService.calculateForceWeight(weight);
        assertEquals(expectedWeight, resultWeight);
    }

    @Test
    void calculateForceWeight_weightProvided_returnsTheCorrectWeightForUranus() {
        double weight = 98.3;
        double expectedWeight = 90.436;
        double resultWeight = uranusGravityService.calculateForceWeight(weight);
        assertEquals(expectedWeight, resultWeight);
    }

    @Test
    void calculateForceWeight_weightProvided_returnsTheCorrectWeightForNeptune() {
        double weight = 98.3;
        double expectedWeight = 110.096;
        double resultWeight = neptuneGravityService.calculateForceWeight(weight);
        assertEquals(expectedWeight, resultWeight);
    }
}