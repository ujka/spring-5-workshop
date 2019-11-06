package com.space.solartravel.services;

import com.space.solartravel.domain.Astronaut;
import com.space.solartravel.domain.SpaceShip;
import com.space.solartravel.repositories.AstronautRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AstronautServiceImpl implements AstronautService {

    private AstronautRepository astronautRepository;

    public AstronautServiceImpl(AstronautRepository astronautRepository) {
        this.astronautRepository = astronautRepository;
    }

    @Override
    public List<Astronaut> findAllBySpaceShip(SpaceShip spaceShip) {
        return astronautRepository.findByAssignedSpaceShip(spaceShip);
    }

    @Override
    public List<Astronaut> findAllUnassigned() {
        return astronautRepository.findAllUnassigned();
    }

    @Override
    public Astronaut findById(Long id) {
        return astronautRepository.findById(id).orElse(null);
    }

    @Override
    public Astronaut save(Astronaut astronaut) {
        return astronautRepository.save(astronaut);
    }
}
