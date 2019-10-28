package com.space.solartravel.repositories;

import com.space.solartravel.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    @Query("select p from Planet p where p.distanceFromEarth <= :travelRange")
    List<Planet> findByDistanceInTravelRange(@Param("travelRange") Long travelRange);
}
