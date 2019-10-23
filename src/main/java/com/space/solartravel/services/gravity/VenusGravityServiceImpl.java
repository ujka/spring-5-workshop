package com.space.solartravel.services.gravity;

import org.springframework.stereotype.Service;

@Service
public class VenusGravityServiceImpl implements GravityService {

    private double surfaceGravity = 0.91;

    @Override
    public double calculateForceWeight(double weight) {
        return weight * surfaceGravity;
    }
}
