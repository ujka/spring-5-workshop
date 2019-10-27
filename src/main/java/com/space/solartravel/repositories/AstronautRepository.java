package com.space.solartravel.repositories;

import com.space.solartravel.domain.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
}
