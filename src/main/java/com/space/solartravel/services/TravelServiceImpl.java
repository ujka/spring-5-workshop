package com.space.solartravel.services;

import com.space.solartravel.domain.SpaceShip;
import com.space.solartravel.domain.Travel;
import com.space.solartravel.repositories.TravelRepository;
import org.springframework.stereotype.Service;

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
}
