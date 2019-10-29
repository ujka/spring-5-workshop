package com.space.solartravel.controllers;

import com.space.solartravel.domain.Planet;
import com.space.solartravel.services.PlanetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PlanetController {

    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/planet/{id}")
    public String getAstronaut(@PathVariable String id, Model model) {
        Planet planet = planetService.findById(Long.valueOf(id));
        model.addAttribute("planet", planet);
        return "planet";
    }
}
