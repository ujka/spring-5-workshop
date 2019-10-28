package com.space.solartravel.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(exclude = "travels")
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
            cascade = CascadeType.ALL)
    private Set<Travel> travels = new HashSet<>();

}
