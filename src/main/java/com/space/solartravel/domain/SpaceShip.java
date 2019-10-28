package com.space.solartravel.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "astronauts")
@ToString(exclude = "astronauts")
@Entity
public class SpaceShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double lightSpeedUnits;
    private Integer capacity;
    private Integer fuelCapacity;
    private Double weight;

    @OneToMany(targetEntity = Astronaut.class,
            mappedBy = "assignedSpaceShip",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Astronaut> astronauts = new HashSet<>();

    @OneToMany(targetEntity = Travel.class,
            mappedBy = "spaceShip",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Travel> travels = new HashSet<>();

}
