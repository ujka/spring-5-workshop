package com.space.solartravel.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SpaceShip {

    @Id
    @GeneratedValue
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLightSpeedUnits() {
        return lightSpeedUnits;
    }

    public void setLightSpeedUnits(Double lightSpeedUnits) {
        this.lightSpeedUnits = lightSpeedUnits;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Integer fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Set<Astronaut> getAstronauts() {
        return astronauts;
    }

    public void setAstronauts(Set<Astronaut> astronauts) {
        this.astronauts = astronauts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpaceShip spaceShip = (SpaceShip) o;

        return id != null ? id.equals(spaceShip.id) : spaceShip.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
