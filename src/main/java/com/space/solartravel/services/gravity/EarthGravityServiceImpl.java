package com.space.solartravel.services.gravity;

import org.springframework.stereotype.Service;

@Service
public class EarthGravityServiceImpl implements GravityService {

    private double surfaceGravity = 1.0;

    @Override
    public double calculateForceWeight(double weight) {
        return weight * surfaceGravity;
    }
}
