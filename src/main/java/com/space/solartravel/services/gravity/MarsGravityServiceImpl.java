package com.space.solartravel.services.gravity;

public class MarsGravityServiceImpl implements GravityService {

    private double surfaceGravity = 0.38;

    @Override
    public double calculateForceWeight(double weight) {
        return weight * surfaceGravity;
    }
}
