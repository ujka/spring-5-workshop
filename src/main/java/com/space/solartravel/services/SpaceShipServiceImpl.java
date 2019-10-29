package com.space.solartravel.services;

import com.space.solartravel.domain.SpaceShip;
import com.space.solartravel.repositories.SpaceShipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceShipServiceImpl implements SpaceShipService {

    private SpaceShipRepository spaceShipRepository;

    public SpaceShipServiceImpl(SpaceShipRepository spaceShipRepository) {
        this.spaceShipRepository = spaceShipRepository;
    }

    @Override
    public List<SpaceShip> findAllSpaceShips() {
        return spaceShipRepository.findAll();
    }
}
