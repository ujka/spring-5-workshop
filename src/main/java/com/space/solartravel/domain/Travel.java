package com.space.solartravel.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@EqualsAndHashCode(exclude = {"planet","spaceShip"})
@Entity
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startedAt;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endedAt;

    @ManyToOne
    @JoinColumn(name = "planet_id")
    private Planet planet;

    @ManyToOne
    @JoinColumn(name = "spaceShip_id")
    private SpaceShip spaceShip;

}
