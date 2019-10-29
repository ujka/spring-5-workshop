package com.space.solartravel.controllers;

import com.space.solartravel.domain.Astronaut;
import com.space.solartravel.domain.Planet;
import com.space.solartravel.domain.SpaceShip;
import com.space.solartravel.domain.Travel;
import com.space.solartravel.services.AstronautService;
import com.space.solartravel.services.PlanetService;
import com.space.solartravel.services.SpaceShipService;
import com.space.solartravel.services.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SpaceShipController {

    private SpaceShipService spaceShipService;

    private AstronautService astronautService;

    private TravelService travelService;

    private PlanetService planetService;

    public SpaceShipController(SpaceShipService spaceShipService, AstronautService astronautService, TravelService travelService, PlanetService planetService) {
        this.spaceShipService = spaceShipService;
        this.astronautService = astronautService;
        this.travelService = travelService;
        this.planetService = planetService;
    }

    @GetMapping("/spaceShip/{id}")
    public String getSpaceShip(@PathVariable String id, Model model) {
        SpaceShip spaceShip = spaceShipService.findById(Long.valueOf(id));
        List<Astronaut> assignedAstronauts = astronautService.findAllBySpaceShip(spaceShip);
        List<Astronaut> unassignedAstronauts = astronautService.findAllUnassigned();
        Travel travel = travelService.findActiveTravelForSpaceShip(spaceShip);
        model.addAttribute("spaceShip", spaceShip);
        model.addAttribute("assignedAstronauts", assignedAstronauts);
        model.addAttribute("activeTravel", travel);
        model.addAttribute("availableAstronauts", unassignedAstronauts);
        return "spaceship";
    }

    @RequestMapping("/assignToShip/{spaceShipId}/{astronautId}")
    public String assignToShip(@PathVariable("spaceShipId") Long spaceShipId,
                               @PathVariable("astronautId") Long astronautId){
        SpaceShip spaceShip = spaceShipService.findById(spaceShipId);
        Astronaut astronaut = astronautService.findById(astronautId);
        spaceShipService.assignAstronautToTheShip(astronaut, spaceShip);
        return "redirect:/spaceShip/" + spaceShipId;
    }

    @RequestMapping("/startTraveling/{planetName}/{spaceShipId}")
    public String startTraveling(@PathVariable("planetName") String planetName,
                                 @PathVariable("spaceShipId") Long spaceShipId){
        SpaceShip spaceShip = spaceShipService.findById(spaceShipId);
        Planet planet = planetService.findByName(planetName);
        travelService.startTraveling(planet, spaceShip);
        return "redirect:/spaceShip/" + spaceShipId;
    }
}
