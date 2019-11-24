package com.space.solartravel.repositories;

import com.space.solartravel.domain.SpaceShip;
import com.space.solartravel.domain.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    List<Travel> findAllBySpaceShip(SpaceShip spaceShip);

    Travel findBySpaceShipAndStartedAtIsNotNullAndEndedAtIsNull(SpaceShip spaceShip);
}
