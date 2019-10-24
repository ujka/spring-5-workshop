package com.space.solartravel.services.gravity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MercuryGravityServiceImpl implements GravityService {

    @Value("${gravity.surface_gravity.mercury}")
    private double surfaceGravity;

    @Override
    public double calculateForceWeight(double weight) {
        return weight * surfaceGravity;
    }
}
