package com.space.solartravel.controllers;

import com.space.solartravel.services.PlanetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private PlanetService planetService;

    public HomeController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @RequestMapping({"", "/", "/home", "/index"})
    public String getHomePage(Model model){
        model.addAttribute("planets", planetService.findAllPlanets());
        return "home";
    }
}
