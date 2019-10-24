package com.space.solartravel.services.gravity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VenusGravityServiceImpl implements GravityService {

    @Value("${gravity.surface_gravity.venus}")
    private double surfaceGravity;

    @Override
    public double calculateForceWeight(double weight) {
        return weight * surfaceGravity;
    }
}
