package com.space.solartravel.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(exclude = "assignedSpaceShip")
@Entity
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private Double weight;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    @ManyToOne
    @JoinColumn(name = "spaceShip_id")
    private SpaceShip assignedSpaceShip;

}
