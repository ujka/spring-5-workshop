package com.space.solartravel.services.gravity;

public class GravityServiceImpl implements GravityService {

    private double surfaceGravity;

    public GravityServiceImpl(double surfaceGravity) {
        this.surfaceGravity = surfaceGravity;
    }

    @Override
    public double calculateForceWeight(double weight) {
        return weight * surfaceGravity;
    }
}
