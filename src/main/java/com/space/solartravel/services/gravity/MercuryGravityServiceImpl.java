package com.space.solartravel.services.gravity;

import org.springframework.stereotype.Service;

@Service
public class MercuryGravityServiceImpl implements GravityService {

    private double surfaceGravity = 0.38;

    @Override
    public double calculateForceWeight(double weight) {
        return weight * surfaceGravity;
    }
}
