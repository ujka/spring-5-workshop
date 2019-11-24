package com.space.solartravel.services;

import com.space.solartravel.domain.Planet;
import com.space.solartravel.domain.SpaceShip;
import com.space.solartravel.domain.Travel;
import com.space.solartravel.repositories.TravelRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TravelServiceImpl implements TravelService {

    private TravelRepository travelRepository;

    public TravelServiceImpl(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    @Override
    public Travel findActiveTravelForSpaceShip(SpaceShip spaceShip) {
        return travelRepository.findBySpaceShipAndStartedAtIsNotNullAndEndedAtIsNull(spaceShip);
    }

    @Override
    public Travel startTraveling(Planet planet, SpaceShip spaceShip) {
        Travel travel = new Travel();
        travel.setSpaceShip(spaceShip);
        travel.setPlanet(planet);
        travel.setStartedAt(new Date());
        return travelRepository.save(travel);
    }
}
