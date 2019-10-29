package com.space.solartravel.services;

import com.space.solartravel.domain.SpaceShip;

import java.util.List;

public interface SpaceShipService {

    List<SpaceShip> findAllSpaceShips();

    SpaceShip findById(Long id);
}
