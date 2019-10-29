package com.space.solartravel.services;

import com.space.solartravel.domain.Astronaut;
import com.space.solartravel.domain.SpaceShip;

import java.util.List;

public interface AstronautService {

    List<Astronaut> findAllBySpaceShip(SpaceShip spaceShip);

    List<Astronaut> findAllUnassigned();

    Astronaut findById(Long id);
}
