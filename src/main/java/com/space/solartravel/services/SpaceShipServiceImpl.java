package com.space.solartravel.services;

import com.space.solartravel.domain.Astronaut;
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

    @Override
    public SpaceShip findById(Long id) {
        return spaceShipRepository.findById(id).orElse(null);
    }

    @Override
    public void assignAstronautToTheShip(Astronaut astronaut, SpaceShip spaceShip) {
        spaceShip.getAstronauts().add(astronaut);
        astronaut.setAssignedSpaceShip(spaceShip);
        spaceShipRepository.save(spaceShip);
    }

    @Override
    public SpaceShip save(SpaceShip spaceShip) {
        return spaceShipRepository.save(spaceShip);
    }
}
