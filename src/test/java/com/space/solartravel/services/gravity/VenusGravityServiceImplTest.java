package com.space.solartravel.services.gravity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = GravityTestConfiguration.class)
class VenusGravityServiceImplTest {

    @Autowired
    @Qualifier("venusGravityServiceImpl")
    private GravityService gravityService;

    @Test
    void calculateForceWeight_weightProvided_returnsTheCorrectWeight() {
        double weight = 98.3;
        double expectedWeight = 89.453;
        double resultWeight = gravityService.calculateForceWeight(weight);
        assertEquals(expectedWeight, resultWeight);
    }
}