package com.space.solartravel.controllers;

import com.space.solartravel.services.PlanetService;
import com.space.solartravel.services.SpaceShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private PlanetService planetService;
    private SpaceShipService spaceShipService;

    public HomeController(PlanetService planetService, SpaceShipService spaceShipService) {
        this.planetService = planetService;
        this.spaceShipService = spaceShipService;
    }

    @RequestMapping({"", "/", "/home", "/index"})
    public String getHomePage(Model model){
        model.addAttribute("planets", planetService.findAllPlanets());
        model.addAttribute("spaceShips", spaceShipService.findAllSpaceShips());
        return "home";
    }
}
