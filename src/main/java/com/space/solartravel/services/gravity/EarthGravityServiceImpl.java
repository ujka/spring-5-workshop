package com.space.solartravel.services.gravity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EarthGravityServiceImpl implements GravityService {

    @Value("${gravity.surface_gravity.earth}")
    private String surfaceGravity;

    @Override
    public double calculateForceWeight(double weight) {
        return weight * getSurfaceGravity();
    }

    private double getSurfaceGravity(){
        return Double.parseDouble(surfaceGravity);
    }
}