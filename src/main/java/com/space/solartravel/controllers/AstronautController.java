package com.space.solartravel.controllers;

import com.space.solartravel.domain.Astronaut;
import com.space.solartravel.services.AstronautService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AstronautController {

    private final AstronautService astronautService;

    public AstronautController(AstronautService astronautService) {
        this.astronautService = astronautService;
    }

    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("astronaut", new Astronaut());
        return "astronaut";
    }

    @PostMapping("/saveAstronaut")
    public String singMeUp(@ModelAttribute Astronaut astronaut){
        astronaut = astronautService.save(astronaut);
        return "redirect:/astronaut/" + astronaut.getId();
    }
}
