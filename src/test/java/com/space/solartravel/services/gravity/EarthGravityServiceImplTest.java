package com.space.solartravel.services.gravity;

import com.space.solartravel.services.gravity.util.BaseGravityTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@BaseGravityTest
class EarthGravityServiceImplTest {

    @Autowired
    private GravityService gravityService;

    @Test
    void calculateForceWeight_weightProvided_returnsTheSameWeight() {
        double weight = 98.3;
        double resultWeight = gravityService.calculateForceWeight(weight);
        assertEquals(weight, resultWeight);
    }
}