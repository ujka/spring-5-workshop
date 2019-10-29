package com.space.solartravel.controllers;

import com.space.solartravel.domain.SpaceShip;
import com.space.solartravel.services.SpaceShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SpaceShipController {

    private SpaceShipService spaceShipService;

    public SpaceShipController(SpaceShipService spaceShipService) {
        this.spaceShipService = spaceShipService;
    }

    @GetMapping("/spaceShip/{id}")
    public String getSpaceShip(@PathVariable String id, Model model) {
        SpaceShip spaceShip = spaceShipService.findById(Long.valueOf(id));
        model.addAttribute("spaceShip", spaceShip);
        return "spaceship";
    }
}
