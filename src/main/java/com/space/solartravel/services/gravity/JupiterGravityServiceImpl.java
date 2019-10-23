package com.space.solartravel.services.gravity;

public class JupiterGravityServiceImpl implements GravityService {

    private double surfaceGravity = 2.34;

    @Override
    public double calculateForceWeight(double weight) {
        return weight * surfaceGravity;
    }
}
