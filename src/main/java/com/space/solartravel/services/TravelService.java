package com.space.solartravel.services;

import com.space.solartravel.domain.SpaceShip;
import com.space.solartravel.domain.Travel;

public interface TravelService {

    Travel findActiveTravelForSpaceShip(SpaceShip spaceShip);
}
