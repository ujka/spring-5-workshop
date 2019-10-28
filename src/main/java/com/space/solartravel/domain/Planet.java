package com.space.solartravel.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double gravity;
    private Long distanceFromEarth;
    private Integer orderInSolarSystem;
    @OneToMany(targetEntity = Travel.class,
            mappedBy = "planet",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Travel> travels = new HashSet<>();

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

    public Set<Travel> getTravels() {
        return travels;
    }

    public void setTravels(Set<Travel> travels) {
        this.travels = travels;
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
