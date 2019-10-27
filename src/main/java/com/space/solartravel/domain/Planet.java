package com.space.solartravel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double gravity;
    private Long distanceFromEarth;
    private Integer orderInSolarSystem;

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

    public Double getGravity() {
        return gravity;
    }

    public void setGravity(Double gravity) {
        this.gravity = gravity;
    }

    public Long getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public void setDistanceFromEarth(Long distanceFromEarth) {
        this.distanceFromEarth = distanceFromEarth;
    }

    public Integer getOrderInSolarSystem() {
        return orderInSolarSystem;
    }

    public void setOrderInSolarSystem(Integer orderInSolarSystem) {
        this.orderInSolarSystem = orderInSolarSystem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Planet planet = (Planet) o;

        return id != null ? id.equals(planet.id) : planet.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
