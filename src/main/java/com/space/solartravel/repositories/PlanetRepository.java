package com.space.solartravel.repositories;

import com.space.solartravel.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
