package com.space.solartravel.controllers;

import com.space.solartravel.domain.Astronaut;
import com.space.solartravel.domain.SpaceShip;
import com.space.solartravel.services.AstronautService;
import com.space.solartravel.services.SpaceShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SpaceShipController {

    private SpaceShipService spaceShipService;

    private AstronautService astronautService;

    public SpaceShipController(SpaceShipService spaceShipService, AstronautService astronautService) {
        this.spaceShipService = spaceShipService;
        this.astronautService = astronautService;
    }

    @GetMapping("/spaceShip/{id}")
    public String getSpaceShip(@PathVariable String id, Model model) {
        SpaceShip spaceShip = spaceShipService.findById(Long.valueOf(id));
        List<Astronaut> asssignedAstronauts = astronautService.findAllBySpaceShip(spaceShip);
        model.addAttribute("spaceShip", spaceShip);
        model.addAttribute("assignedAstronauts", asssignedAstronauts);
        return "spaceship";
    }
}
