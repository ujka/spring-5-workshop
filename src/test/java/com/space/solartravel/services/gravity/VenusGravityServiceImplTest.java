package com.space.solartravel.services.gravity;

import com.space.solartravel.services.gravity.util.BaseGravityTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@BaseGravityTest
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