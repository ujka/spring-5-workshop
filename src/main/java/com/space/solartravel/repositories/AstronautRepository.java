package com.space.solartravel.repositories;

import com.space.solartravel.domain.Astronaut;
import com.space.solartravel.domain.SpaceShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AstronautRepository extends JpaRepository<Astronaut, Long> {

    @Query("select a from Astronaut a where a.assignedSpaceShip = :spaceShip")
    List<Astronaut> findByAssignedSpaceShip(@Param("spaceShip") SpaceShip spaceShip);

    @Query("select a from Astronaut a where a.assignedSpaceShip is null")
    List<Astronaut> findAllUnassigned();
}
