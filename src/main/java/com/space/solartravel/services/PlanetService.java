package com.space.solartravel.services;

import com.space.solartravel.domain.Planet;

import java.util.List;

public interface PlanetService {

    List<Planet> findAllPlanets();

    Planet findById(Long id);

    Planet findByName(String name);
}
