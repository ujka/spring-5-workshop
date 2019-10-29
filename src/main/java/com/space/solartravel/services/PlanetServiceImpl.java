package com.space.solartravel.services;

import com.space.solartravel.domain.Planet;
import com.space.solartravel.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetServiceImpl implements PlanetService {

    private PlanetRepository planetRepository;

    public PlanetServiceImpl(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Override
    public List<Planet> findAllPlanets() {
        return planetRepository.findAll();
    }
}
