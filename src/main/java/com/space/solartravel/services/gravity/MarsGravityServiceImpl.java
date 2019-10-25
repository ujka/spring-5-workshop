package com.space.solartravel.services.gravity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:gravity.properties")
public class MarsGravityServiceImpl implements GravityService {

    @Value("${gravity.surface_gravity.mars}")
    private double surfaceGravity;

    @Override
    public double calculateForceWeight(double weight) {
        return weight * surfaceGravity;
    }
}
